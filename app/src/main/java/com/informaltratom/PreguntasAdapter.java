package com.informaltratom;

import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by beto on 8/10/15.
 */
public class PreguntasAdapter extends ArrayAdapter<Pregunta> {
    public PreguntasAdapter(Context context ,int resource , List<Pregunta> objects){
        super (context, resource,objects);
    }
    @Override
    public View getView(int position , View convertView, ViewGroup parent){
        View itemView = LayoutInflater.from(getContext()).inflate(R.layout.pregunta, parent, false);
        Pregunta pregunta = getItem(position);

        TextView textView1 = (TextView)itemView.findViewById(R.id.pregunta);
        textView1.setText(pregunta.pregunta);

        TextView textView2 = (TextView)itemView.findViewById(R.id.respuesta);
        textView2.setText(pregunta.respuesta);

        return itemView;
    }
}
