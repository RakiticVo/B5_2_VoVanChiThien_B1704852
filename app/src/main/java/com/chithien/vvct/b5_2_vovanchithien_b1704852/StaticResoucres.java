package com.chithien.vvct.b5_2_vovanchithien_b1704852;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class StaticResoucres extends AppCompatActivity {

    TextView hd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_static_resoucres);

        hd = findViewById(R.id.hd);
        InputStream inputStream = this.getResources().openRawResource(R.raw.huongdan);
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);

        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

        String src = null;

        try {
            while ((src = bufferedReader.readLine()) != null){
                hd.setText(src);
            }
        }catch (IOException e) {
            e.printStackTrace();
        } ;

    }
}