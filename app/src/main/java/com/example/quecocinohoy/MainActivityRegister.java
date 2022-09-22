package com.example.quecocinohoy;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivityRegister extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    private TextView tvEdad;
    private SeekBar seekBarEdad;
    String [] sexos = {"Masculino", "Femenino", "No binario", "Otros"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_register);
        //se va a declarar la parte logica con lo visual.
        TextView tvEdad = (TextView) findViewById(R.id.tvEdad);
        Spinner spin = (Spinner) findViewById(R.id.spinnerSexo);
        SeekBar seekBarEdad = (SeekBar)findViewById(R.id.seekBar);
        spin.setOnItemSelectedListener(this);


        //se llama al adapter para instanciar la lista
        ArrayAdapter aa = new ArrayAdapter(this,android.R.layout.simple_spinner_item,sexos);

        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spin.setAdapter(aa);

        //utilizacion del seekbar para saber la edad del usuario.

        seekBarEdad.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                seekBarEdad.setMax(100);
                tvEdad.setText("Edad : " + i);

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

    }


    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}