package com.dridimedamine.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;


import com.dridimedamine.entites.Depot;
import com.dridimedamine.entites.Produit;
import com.dridimedamine.inventaire.ComptageActivity;
import com.dridimedamine.inventaire.R;

import java.util.List;

public class DepotAdapter extends ArrayAdapter<Depot> {

    private Activity activity;
    private Context context;
    private List<Depot> depot;



    public DepotAdapter(@NonNull Context context, @LayoutRes int resource, @NonNull List<Depot> objects) {
        super(context, resource, objects);
        this.context=context;
        this.depot=objects;

    }

    @Override
    public View getView(final int pos, View convertView, ViewGroup parent){
        LayoutInflater inflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.depotlist,parent,false);

        TextView nom=(TextView) rowView.findViewById(R.id.nomD);

        nom.setText(""+depot.get(pos).getAdresse());




        return rowView;



    }

}


