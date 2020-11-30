package com.nahuel.petagram;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.content.Intent;

public class Contacto extends AppCompatActivity {

    private Toolbar toolbar;

    EditText etNombre;
    EditText etCorreo;
    EditText etMensaje;
    Button btnEnviar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacto);

        toolbar = (Toolbar) findViewById(R.id.toolbar);

        if (toolbar != null){
            setSupportActionBar(toolbar);
        }

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        etNombre = (EditText)findViewById(R.id.etNombre);
        etCorreo = (EditText)findViewById(R.id.etCorreo);
        etMensaje = (EditText)findViewById(R.id.etMensaje);
        btnEnviar = (Button)findViewById(R.id.btnEnviar);

        btnEnviar.setOnClickListener(view -> {
            String enviarcorreo = etCorreo.getText().toString();
            String enviarasunto = etNombre.getText().toString();
            String enviarmensaje = etMensaje.getText().toString();

            // Defino mi Intent y hago uso del objeto ACTION_SEND
            Intent intent = new Intent(Intent.ACTION_SEND);

            // Defino los Strings Email, Asunto y Mensaje con la función putExtra
            intent.putExtra(Intent.EXTRA_EMAIL,
                    new String[] { enviarcorreo });
            intent.putExtra(Intent.EXTRA_SUBJECT, enviarasunto);
            intent.putExtra(Intent.EXTRA_TEXT, enviarmensaje);

            // Establezco el tipo de Intent
            intent.setType("message/rfc822");

            // Lanzo el selector de cliente de Correo
            startActivity(
                    Intent
                            .createChooser(intent,
                                    "Elije un cliente de Correo:"));
        });

    }

}