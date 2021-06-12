package com.example.temperatureconversion;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {

    EditText masukan;
    TextView hasil;
    ToggleButton konversi;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().hide();

        masukan = (EditText) findViewById(R.id.inputtext);
        hasil = (TextView) findViewById(R.id.textView3);
        konversi = (ToggleButton) findViewById(R.id.toggleButton);



        masukan.addTextChangedListener(new TextWatcher() {

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @SuppressLint("SetTextI18n")
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (konversi.isChecked()) {
                    double nomer = TextUtils.isEmpty(masukan.getText().toString()) ? 0 : Double.parseDouble(masukan.getText().toString());
                    double fahrenheit = (nomer *9/5+32);
                    hasil.setText(Math.round(fahrenheit)+"°F");
                }else{
                    double nomer = TextUtils.isEmpty(masukan.getText().toString()) ? 0 : Double.parseDouble(masukan.getText().toString());
                    double celcius = ((nomer -32)*5/9);
                    hasil.setText(Math.round(celcius)+"°C");
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }
}
