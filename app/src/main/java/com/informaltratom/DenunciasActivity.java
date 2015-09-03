package com.informaltratom;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.Toast;

import com.parse.FindCallback;
import com.parse.ParseFile;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.ParseException;

import java.util.ArrayList;
import java.util.List;


public class DenunciasActivity extends Activity {

    private String questions[];
    private ListView listView;
    private ArrayList<Denuncia> denuncias;
    private DenunciasAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_denuncias);

        denuncias = new ArrayList<Denuncia>();
        //denuncias.add(new Denuncia("Juan Perez","Marcela Mamani","Mucha volencia en la casa"));

        adapter = new DenunciasAdapter(this,R.layout.denuncia, denuncias);

        ParseQuery query = new ParseQuery("Denuncia");
        query.addDescendingOrder("createdAt");
        query.findInBackground(new FindCallback<ParseObject>() {

            @Override
            public void done(List<ParseObject> reports, ParseException e) {
                if (e == null) {
                    Log.d("Report", "Recuperados " + reports.size() + " reportes");
                    for (ParseObject report : reports) {
                        adapter.add(new Denuncia((String) report.get("nombre_agresor"), (String) report.get("nombre_victima"), (String) report.get("descripcion")));
                        try {
                            report.pin();
                        } catch (ParseException e1) {
                            e1.printStackTrace();
                        }
                    }
                } else {
                    e.printStackTrace();
                    Log.e("Report", "Error: " + e.getMessage());
                    Toast.makeText(DenunciasActivity.this, "Ocurrio un error al recuperar los reportes, por favor vuelva a intentar", Toast.LENGTH_SHORT).show();
                }
            }
        });



        listView = (ListView)findViewById(R.id.listView);

        listView.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_denuncias, menu);
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
