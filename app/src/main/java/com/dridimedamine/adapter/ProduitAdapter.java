package com.dridimedamine.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.dridimedamine.entites.Depot;
import com.dridimedamine.entites.Produit;
import com.dridimedamine.inventaire.R;

import java.util.List;

public class ProduitAdapter extends ArrayAdapter<Produit> {
    private Context context;
    private List<Produit> produit;

    public ProduitAdapter(@NonNull Context context, int resource, @NonNull List<Produit> objects) {
        super(context, resource, objects);
        this.context=context;
        this.produit=objects;
    }

    @Override
    public View getView(final int pos, View convertView, ViewGroup parent){
        LayoutInflater inflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.activity_produit,parent,false);


        TextView nom=(TextView) rowView.findViewById(R.id.nomP);

        nom.setText(""+produit.get(pos).getNom());

        Log.v("list", "onResponse: "+produit);




        return rowView;



    }
}
