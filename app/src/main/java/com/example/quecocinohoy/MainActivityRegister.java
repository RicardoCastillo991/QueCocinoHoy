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
import java.util.ArrayList;

public class MainActivityRegister extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    private TextView tvEdad;
    private EditText txtNombre, txtApellido, txtCorreo;
    private SeekBar seekBarEdad;
    int valorSeekBar;
    String [] sexos = {"Masculino", "Femenino", "No binario", "Otros"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_register);
        //se va a declarar la parte logica con lo visual.
        Button btnRegistrar2Step = (Button) findViewById(R.id.btnRegistrarseRegistro);
        txtCorreo = findViewById(R.id.txtCorreoRegister);
        tvEdad = findViewById(R.id.tvEdad);
        txtNombre = findViewById(R.id.txtNombreRegister);
        txtApellido = findViewById(R.id.txtApellidoRegister);
        Spinner spin = (Spinner) findViewById(R.id.spinnerSexo);
        seekBarEdad = findViewById(R.id.seekBar);
        ArrayList<String> datos = new ArrayList<String>();

        spin.setOnItemSelectedListener(this);
        //se llama al adapter para instanciar la lista
        ArrayAdapter aa = new ArrayAdapter(this,android.R.layout.simple_spinner_item,sexos);

        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spin.setAdapter(aa);

        //utilizacion del seekbar para saber la edad del usuario.

        seekBarEdad.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                seekBarEdad.setMax(99);
                valorSeekBar = i + 1;
                tvEdad.setText("Edad : " + (String.valueOf(valorSeekBar)));

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });


        String correoUsuario = txtCorreo.getText().toString();
        String edadUsuario = String.valueOf(valorSeekBar);
        String nombreUsuario = txtNombre.getText().toString();
        String apellidoUsuario = txtApellido.getText().toString();
        String sexoUsuario = spin.getOnItemSelectedListener().toString();
        //Agregacion de boton con confirmacion de datos (simulando una base de datos).
        btnRegistrar2Step.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!(correoUsuario.equals("hola1@gmail.com"))){
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            datos.add(nombreUsuario);
                            datos.add(apellidoUsuario);
                            datos.add(correoUsuario);
                            datos.add(edadUsuario);
                            datos.add(sexoUsuario);
                            Bundle bundle = new Bundle();
                            bundle.putStringArrayList("datos", datos);
                        }
                    });
                    Intent intent = new Intent(MainActivityRegister.this , MainActivityRegister2Step.class);
                    startActivity(intent);
                    Toast registroExitoso = Toast.makeText(MainActivityRegister.this, "¡Registro casi completado!", Toast.LENGTH_LONG);
                    registroExitoso.show();
                }
                else
                {
                    txtCorreo.setText("");
                    Toast mensajeError = Toast.makeText(MainActivityRegister.this, "¡El correo que ha ingresado ya existe!", Toast.LENGTH_LONG);
                    mensajeError.show();
                }
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