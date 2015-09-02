package com.informaltratom;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import java.util.ArrayList;


public class PreguntasPropuestasActivity extends Activity {
    private String questions[];
    private ListView listView;
    private ArrayList<Pregunta>preguntas;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preguntas_propuestas);
        preguntas = new ArrayList<Pregunta>();
        preguntas.add(new Pregunta("¿Puede una mujer cambiar el comportamiento de un hombre violento sola sin la ayuda de algún profesional?"
                , "“Nadie puede cambiar a nadie su comportamiento, si esa persona no desea asumir por su propia cuenta el deseo de cambio”, asegura Lisa Kohn.\n" +
                "\n" +
                "Un hombre violento es una persona que necesita amor y apoyo de profesionales, de familiares y de amigos, pero sobre todo, necesita tomar la decisión de querer dar vuelta a su vida en forma positiva.\n" +
                "\n" +
                "Además, en el momento en que la mujer ocupa el papel de víctima, es imposible que ella ayude al otro, pues en ese momento, ella no puede apoyarse ni a sí misma. "));
        preguntas.add(new Pregunta("¿Cómo convencer a una mujer que abandonar a un hombre que la maltrata no es traicionar el compromiso del matrimonio?"
                , "Lisa opina que en realidad no es cuestión de “convencerla”, pues la decisión tiene que venir desde adentro de cada quien, pero sí se puede ayudar en el proceso de reconocer su realidad y apoyarle en sus decisiones.\n" +
                "\n" +
                "También es importante que los líderes y formadores de opinión, empiecen a entender y a promover que el maltrato es absolutamente inaceptable.\n" +
                "\n" +
                "Existen otras alternativas que hay que replantearnos socialmente, como rehabilitar al maltratador y a su familia, pues si no lo hacemos, la víctima caerá en manos de otro maltratador y el maltratador se buscará otra víctima porque no se han roto los ciclos de la violencia.\n" +
                "\n" +
                "Yolanda Calva, por su parte, considera importante poner en acción mecanismos de apoyo auténtico y válido para las mujeres sin “re victimizarlas”, y entendiendo que ser víctima tampoco la invalida como ser humano, es un paso al auténtico cambio en beneficio de las mujeres."));
        preguntas.add(new Pregunta("¿Tiene culpa la mujer? " , "\"Ninguna\", en este sentido es importante que toda la sociedad la apoye y \"no se debe culpabilizar ni buscar la razón por la que esa mujer está sufriendo esa violencia\".\n"));
        preguntas.add(new Pregunta("¿Que es la violencia? " , "La violencia es todo acto de agresion fisica, psicologica y sexual, cometido por una persona que atenta contra la integridad de otra. "));
        listView = (ListView)findViewById(R.id.listView);
        PreguntasAdapter adapter = new PreguntasAdapter(this, R.layout.pregunta, preguntas);
        listView.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_preguntas_propuestas, menu);
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
