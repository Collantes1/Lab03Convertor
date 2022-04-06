package com.example.lab03convertor;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Spinner spFrom;
    Spinner spTo;
    EditText etFrom;
    TextView tvTo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spFrom = findViewById(R.id.lstFrom);
        spTo = findViewById(R.id.lstTo);
        etFrom = findViewById(R.id.txtFrom);
        tvTo = findViewById(R.id.txtTo);

        ArrayAdapter <String> adp = new <String> ArrayAdapter(this, android.R.layout.simple_list_item_1);
        adp.add("mm");
        adp.add("cm");
        adp.add("m");
        adp.add("km");

        spFrom.setAdapter(adp);
        spTo.setAdapter(adp);
    }

    public void on_convert(View v)
    {
        float from = Float.parseFloat(etFrom.getText().toString());

        String sFrom = (String) spFrom.getSelectedItem();
        String sTo = (String) spTo.getSelectedItem();

        float to = 0.0f;

        if (sFrom.equals("mm"))
        {
            if(sTo.equals("mm")) to = from * 1f;
            if(sTo.equals("cm")) to = from * 0.1f;
            if(sTo.equals("m")) to = from * 0.001f;
            if(sTo.equals("km")) to = from * 0.000001f;
        }

        tvTo.setText(String.valueOf(to));
    }
}