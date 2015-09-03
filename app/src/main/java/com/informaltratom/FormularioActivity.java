package com.informaltratom;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.parse.ParseObject;

import java.util.ArrayList;


public class FormularioActivity extends Activity {
    private EditText nombreA;
    private EditText nombreV;
    private EditText infoAgre;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario);

        nombreA = (EditText) findViewById(R.id.nombreA);
        nombreV = (EditText) findViewById(R.id.nombreV);
        infoAgre = (EditText) findViewById(R.id.infoAgre);

        Button registrar = (Button) findViewById(R.id.registrarDenuncia);
        registrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ParseObject report = new ParseObject("Denuncia");
                report.put("descripcion", infoAgre.getText().toString());
                report.put("nombre_agresor", nombreA.getText().toString());
                report.put("nombre_victima", nombreV.getText().toString());
                report.saveInBackground();

                Toast.makeText(FormularioActivity.this, "Denuncia Registrada", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_formulario, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
