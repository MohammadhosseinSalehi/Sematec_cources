package com.example.sematec_1.Activities;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.sematec_1.R;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class AzanActivity extends AppCompatActivity {

    ArrayAdapter<String> cityAdapter;
    Spinner citySpinner;
    String[] cities;

    Button showAzanTime_btn;
    String url;
    String strMaghrib;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_azan);

        cities= new String[]{"Tehran", "Mashhad","Qom"};
        citySpinner = findViewById(R.id.city_spinner);
        cityAdapter = new ArrayAdapter<String>(this,R.layout.support_simple_spinner_dropdown_item,cities);
        citySpinner.setAdapter(cityAdapter);
        final TextView azanTime_txt = findViewById(R.id.azanTime_tv);
        azanTime_txt.setText("Running");

        String city = citySpinner.getSelectedItem().toString();
        url="https://api.aladhan.com/v1/timingsByCity?city="+city+"&country=Iran&method=8";

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {

                    TextView azanTime_txt = findViewById(R.id.azanTime_tv);
                    URL obj = new URL(url);
                    HttpURLConnection con = (HttpURLConnection) obj.openConnection();
                    con.setRequestMethod("GET");
                    con.setRequestProperty("User-Agent", "Mozilla/5.0");
                    int responseCode = con.getResponseCode();
                    if (responseCode == HttpURLConnection.HTTP_OK) {
                        BufferedReader in = new BufferedReader(new InputStreamReader(
                                con.getInputStream()));
                        String inputLine;
                        StringBuffer response = new StringBuffer();
                        while ((inputLine = in.readLine()) != null) {
                            response.append(inputLine);
                        }
                        JSONObject objResponse = new JSONObject(response.toString());
                        String strData = objResponse.getString("data");
                        JSONObject objData = new JSONObject(strData);
                        String strTimings = objData.getString("timings");
                        JSONObject objTimings = new JSONObject(strTimings);
                        strMaghrib = objTimings.getString("Maghrib");
                        System.out.print(strMaghrib);
                    }else {

                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }


            }
        }).start();

        showAzanTime_btn = findViewById(R.id.azanTime_btn);
        showAzanTime_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                azanTime_txt.setText(strMaghrib);
            }
        });

    }
}
