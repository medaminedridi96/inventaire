package com.dridimedamine.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;

import com.dridimedamine.entites.Agent;
import com.dridimedamine.entites.Produit;
import com.dridimedamine.inventaire.R;

import java.util.List;

public class AgentAdapter extends ArrayAdapter<Agent> {

    private Context context;
    private List<Agent> agents;
    private List<Produit> produits;


    public AgentAdapter(@NonNull Context context, @LayoutRes int resource, @NonNull List<Agent> objects) {
        super(context, resource, objects);
        this.context=context;
        this.agents=objects;
    }

    @Override
    public View getView(final int pos, View convertView, ViewGroup parent){
        LayoutInflater inflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.agentslist,parent,false);

        TextView nom=(TextView) rowView.findViewById(R.id.nom);
        TextView prenom=(TextView) rowView.findViewById(R.id.prenom);


        nom.setText(""+agents.get(pos).getNom());
        prenom.setText(""+agents.get(pos).getPrenom());


        return rowView;


    }
}
