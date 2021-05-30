package com.chithien.vvct.b5_2_vovanchithien_b1704852;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class MainActivity extends AppCompatActivity {
    EditText textBox;
    Button SaveExt, LoadExt, help, reset;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textBox = findViewById(R.id.txtText1);
        SaveExt = (Button)findViewById(R.id.btnSave2);
        LoadExt = (Button)findViewById(R.id.btnLoad2);
        reset = findViewById(R.id.btn_reset);
        help = (Button) findViewById(R.id.help);

        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textBox.setText("");
                textBox.setHint(null);
            }
        });

        help.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, StaticResoucres.class));
            }
        });

        textBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textBox.setText("");
            }
        });


    }

    static final int READ_BLOCK_SIZE = 100;
    public void onClickSaveInternal(View view) {
        String str =  textBox.getText().toString();
        try {
            FileOutputStream fileOutputStream = openFileOutput("textfile.txt", MODE_APPEND);
            OutputStreamWriter writer = new OutputStreamWriter(fileOutputStream);
            writer.write(str);
            writer.flush();
            writer.close();
            Toast.makeText(getBaseContext(), "File saved successfully!", Toast.LENGTH_SHORT).show();
            textBox.setText("");
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void onClickLoadInternal(View view) {
        try {
            FileInputStream inputStream = openFileInput("textfile.txt");
            InputStreamReader reader = new InputStreamReader(inputStream);
            char[] inputBuffer = new char[READ_BLOCK_SIZE];
            String str="";
            int charRead;
            while ((charRead = reader.read(inputBuffer)) >0){
                String readString = String.copyValueOf(inputBuffer, 0, charRead);
                str += readString;
                inputBuffer = new char[READ_BLOCK_SIZE];
            }
            textBox.setText(str);
            Toast.makeText(getBaseContext(), "File loaded successfully!",Toast.LENGTH_SHORT).show();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void onClickSaveExternal(View view) {
        String str =  textBox.getText().toString();
        try {
            File sdCard = Environment.getExternalStorageDirectory();
            File directory = new File (sdCard.getAbsolutePath() + "/Documents");
            directory.mkdirs();

            File file = new File(directory, "textfile.txt");
            FileOutputStream outputStream = new FileOutputStream(file);
            OutputStreamWriter writer = new OutputStreamWriter(outputStream);
            writer.write(str);
            writer.flush();
            writer.close();
            Toast.makeText(getBaseContext(),"File saved successfully!", Toast.LENGTH_SHORT).show();
            textBox.setText("");
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void onClickLoadExternal(View view) {
        try {
            File sdCard = Environment.getExternalStorageDirectory();
            File directory = new File(sdCard.getAbsolutePath() + "/Documents");
            directory.mkdirs();

            File file = new File(directory, "textfile.txt");
            FileInputStream inputStream = new FileInputStream(file);
            InputStreamReader reader = new InputStreamReader(inputStream);
            char[] inputBuffer = new char[READ_BLOCK_SIZE];
            String str="";
            int charRead;
            while ((charRead = reader.read(inputBuffer)) >0){
                String readString = String.copyValueOf(inputBuffer, 0, charRead);
                str += readString;
                inputBuffer = new char[READ_BLOCK_SIZE];
            }
            textBox.setText(str);
            Toast.makeText(getBaseContext(), "File loaded successfully!",Toast.LENGTH_SHORT).show();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}