package com.example.weather_parsiran;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.weather_parsiran.w.Parsw;
import com.google.gson.Gson;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;

import org.json.JSONObject;

import androidx.appcompat.app.AppCompatActivity;
import cz.msebera.android.httpclient.Header;

public class MainActivity extends AppCompatActivity {
    Button btnsrc;
    EditText txtserch;
    TextView txttoday;
    TextView txtday;
    TextView txtdayy;
    TextView txtdayyy;
    TextView txtdayyyy;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        btnsrc=(Button) findViewById(R.id.btnsrc);
        txtserch=(EditText) findViewById(R.id.txtserch);
        txttoday=(TextView) findViewById(R.id.btnsrc);
        txtday=(TextView) findViewById(R.id.btnsrc);
        txtdayy=(TextView) findViewById(R.id.btnsrc);
        txtdayyy=(TextView) findViewById(R.id.btnsrc);
        txtdayyyy=(TextView) findViewById(R.id.btnsrc);
        setContentView(R.layout.activity_main);


        btnsrc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url="https://samples.openweathermap.org/data/2.5/forecast?lat=35&lon=139&appid=b6907d289e10d714a6e88b30761fae22";

                AsyncHttpClient asyncHttpClient = new AsyncHttpClient();
                asyncHttpClient.get(url,new JsonHttpResponseHandler(){

                    @Override
                    public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                        super.onSuccess(statusCode, headers, response);
                        Gson gson=new Gson();
                        Parsw cn = gson.fromJson(response.toString(),Parsw.class);
                        Integer cnt = cn.getMain().getHumidity();
                        Toast.makeText(MainActivity.this,cnt, Toast.LENGTH_SHORT).show();

                    }
                        @Override
                    public void onFailure(int statusCode, Header[] headers, Throwable throwable, JSONObject errorResponse) {
                        super.onFailure(statusCode, headers, throwable, errorResponse);
                        Toast.makeText(MainActivity.this,"dsfsdfsdf", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });

    }
}
