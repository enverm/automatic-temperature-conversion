package com.example.temperatureconversion;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    EditText masukan;
    TextView hasil;
    Spinner dropdown;

    int urutan;

    String[] items = new String[]{
            "Celcius ke Fahrenheit",
            "Celcius ke Kelvin",
            "Fahrenheit ke Celcius",
            "Fahrenheit ke Kelvin",
            "Kelvin ke Celcius",
            "Kelvin ke Fahrenheit"
    };

        @Override
        protected void onCreate (Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().hide();

        masukan = (EditText) findViewById(R.id.inputtext);
        hasil = (TextView) findViewById(R.id.textView3);
        dropdown = (Spinner) findViewById(R.id.spinner);

        dropdown.setOnItemSelectedListener(this);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, items);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        dropdown.setAdapter(adapter);

        masukan.addTextChangedListener(new TextWatcher() {

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @SuppressLint("SetTextI18n")

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (urutan == 0) {
                    double nomer = TextUtils.isEmpty(masukan.getText().toString()) ? 0 : Double.parseDouble(masukan.getText().toString());
                    double fahrenheit = (nomer * 9 / 5 + 32);
                    hasil.setText(Math.round(fahrenheit) + "°F");
                } else if (urutan == 1) {
                    double nomer = TextUtils.isEmpty(masukan.getText().toString()) ? 0 : Double.parseDouble(masukan.getText().toString());
                    double kelvin = (nomer+273);
                    hasil.setText(Math.round(kelvin) + "°K");
                } else if (urutan == 2) {
                    double nomer = TextUtils.isEmpty(masukan.getText().toString()) ? 0 : Double.parseDouble(masukan.getText().toString());
                    double celcius = ((nomer - 32) * 5 / 9);
                    hasil.setText(Math.round(celcius) + "°C");
                } else if (urutan == 3) {
                    double nomer = TextUtils.isEmpty(masukan.getText().toString()) ? 0 : Double.parseDouble(masukan.getText().toString());
                    double celcius = ((nomer - 32) * 5 / 9);
                    double kelvin = (celcius+273);
                    hasil.setText(Math.round(kelvin) + "°K");
                } else if (urutan == 4) {
                    double nomer = TextUtils.isEmpty(masukan.getText().toString()) ? 0 : Double.parseDouble(masukan.getText().toString());
                    double celcius = nomer - 273;
                    hasil.setText(Math.round(celcius) + "°C");
                } else {
                    double nomer = TextUtils.isEmpty(masukan.getText().toString()) ? 0 : Double.parseDouble(masukan.getText().toString());
                    double celcius = nomer - 273;
                    double fahrenheit = (celcius * 9 / 5 + 32);
                    hasil.setText(Math.round(fahrenheit) + "°F");
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        urutan = position;
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
