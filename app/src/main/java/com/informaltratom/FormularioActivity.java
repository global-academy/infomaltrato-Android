package com.informaltratom;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import java.util.ArrayList;


public class FormularioActivity extends Activity {
    private String questions[];
    private ListView listView;
    private ArrayList<Denuncia> denuncias;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario);
        denuncias = new ArrayList<Denuncia>();
        denuncias.add(new Denuncia("Juan Perez","Marcela Mamani","Mucha volencia en la casa"));
        listView = (ListView)findViewById(R.id.listView);
        DenunciasAdapter adapter = new DenunciasAdapter(this,R.layout.denuncia, denuncias);
        listView.setAdapter(adapter);

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
