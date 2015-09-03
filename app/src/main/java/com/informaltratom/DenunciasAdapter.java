package com.informaltratom;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by beto on 8/10/15.
 */
public class DenunciasAdapter extends ArrayAdapter<Denuncia> {
    public DenunciasAdapter(Context context, int resource, List<Denuncia> objects){
        super (context, resource,objects);
    }
    @Override
    public View getView(int position , View convertView, ViewGroup parent){
        View itemView = LayoutInflater.from(getContext()).inflate(R.layout.denuncia, parent, false);
        Denuncia denucia = getItem(position);

        TextView textView1 = (TextView)itemView.findViewById(R.id.nombreA);
        textView1.setText("Agresor: " + denucia.nombreAgresor);

        TextView textView2 = (TextView)itemView.findViewById(R.id.nombreV);
        textView2.setText("Victima: "+denucia.nombreVictima);

        TextView textView3 = (TextView)itemView.findViewById(R.id.infoAgre);
        textView3.setText(denucia.infoAgrecion);

        return itemView;
    }
}
