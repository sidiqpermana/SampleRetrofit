package com.sidiq.intel.sampleretrofit;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import java.util.ArrayList;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class MainActivity extends AppCompatActivity {
    private ProgressDialog progressDialog;
    private TextView txtResult;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        txtResult = (TextView)findViewById(R.id.txt_result);

        progressDialog = new ProgressDialog(MainActivity.this);
        progressDialog.setMessage("Please wait...");

        requestAsync();
    }

    private void requestAsync() {
        progressDialog.show();

        MatchClient matchClient = ServiceGenerator.createService(MatchClient.class);
        matchClient.getMatches(new Callback<ArrayList<MatchItems>>() {
            @Override
            public void success(ArrayList<MatchItems> list, Response response) {
                String result = "";

                for (int i = 0; i < list.size(); i++) {
                    result += list.get(i).teamHome + " vs " + list.get(i).teamAway + "<br><br>";
                }

                txtResult.setText(Html.fromHtml(result));

                progressDialog.dismiss();
            }

            @Override
            public void failure(RetrofitError error) {
                progressDialog.dismiss();
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
