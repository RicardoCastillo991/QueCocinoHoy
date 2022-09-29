package com.example.quecocinohoy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivityRegister extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    private TextView tvEdad;
    private SeekBar seekBarEdad;
    String [] sexos = {"Masculino", "Femenino", "No binario", "Otros"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_register);
        //se va a declarar la parte logica con lo visual.
        Button btnRegistrar2Step = (Button) findViewById(R.id.btnRegistrarseRegistro);
        EditText txtCorreoRegister = (EditText) findViewById(R.id.txtCorreoRegister);
        TextView tvEdad = (TextView) findViewById(R.id.tvEdad);
        Spinner spin = (Spinner) findViewById(R.id.spinnerSexo);
        SeekBar seekBarEdad = (SeekBar)findViewById(R.id.seekBar);

        //Agregacion de boton con confirmacion de datos (simulando una base de datos).
        btnRegistrar2Step.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String correoUsuario;
                correoUsuario = txtCorreoRegister.getText().toString();
                if(!(correoUsuario.equals("hola1@gmail.com"))){
                    Intent intento = new Intent(MainActivityRegister.this, MainActivityRegister2Step.class);
                    startActivity(intento);
                    Toast registroExitoso = Toast.makeText(MainActivityRegister.this, "¡Registro casi completado!", Toast.LENGTH_LONG);
                    registroExitoso.show();
                }
                else
                {
                    txtCorreoRegister.setText("");
                    Toast mensajeError = Toast.makeText(MainActivityRegister.this, "¡El correo que ha ingresado ya existe!", Toast.LENGTH_LONG);
                    mensajeError.show();
                }
            }
        });

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