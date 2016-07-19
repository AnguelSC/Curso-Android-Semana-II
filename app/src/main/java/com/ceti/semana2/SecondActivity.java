package com.ceti.semana2;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Intent intent = getIntent();
        int resultado = intent.getExtras().getInt("resultado");
        Button btn = (Button) findViewById(R.id.miBoton);
        btn.setText("Resultado es:"+ resultado);
        Button enviar = (Button) findViewById(R.id.enviar);
        final EditText numero = (EditText) findViewById(R.id.numero);
        final EditText mensaje = (EditText) findViewById(R.id.mensaje);
        enviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW,
                        Uri.parse("sms:" + numero.getText().toString()));
                intent.putExtra("sms_body", mensaje.getText().toString());
                startActivity(intent);
            }
        });
        //Toast.makeText(SecondActivity.this, "Resultado"+resultado, Toast.LENGTH_SHORT).show();
    }
}
