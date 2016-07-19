package com.ceti.semana2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button boton = (Button) findViewById(R.id.btnEnviar);
        final List<String> lista = new ArrayList<>();
        lista.add("Chaufa");
        lista.add("Ceviche");
        lista.add("Chaufa");
        lista.add("Tortilla");
        lista.add("Chaufa");
        lista.add("Cafe");
        ListView listv = (ListView) findViewById(R.id.lista);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getApplicationContext(),
                R.layout.mivista, lista);
        listv.setAdapter(adapter);
        listv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(),lista.get(position),Toast.LENGTH_LONG).show();
            }
        });
        listv.deferNotifyDataSetChanged();
        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                EditText campo1 = (EditText) findViewById(R.id.primer_numero);
                int primer_numero = Integer.parseInt(campo1.getText().toString());

                EditText campo2 = (EditText) findViewById(R.id.segundo_numero);
                int segundo_numero = Integer.parseInt(campo2.getText().toString());

                int suma = primer_numero+segundo_numero;
                //Toast.makeText(getApplication(),"Suma es:"+suma,Toast.LENGTH_LONG).show();
                Intent intent = new Intent(MainActivity.this,SecondActivity.class);
                intent.putExtra("resultado",suma);
                startActivity(intent);
            }
        });
        }

}