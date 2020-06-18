package com.dridimedamine.inventaire;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.dridimedamine.adapter.AgentAdapter;
import com.dridimedamine.adapter.DepotAdapter;
import com.dridimedamine.adapter.ProduitAdapter;
import com.dridimedamine.entites.Agent;
import com.dridimedamine.entites.Depot;
import com.dridimedamine.entites.Produit;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ProduitActivity extends AppCompatActivity  {
    List<Produit> list = new ArrayList<>();



    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_produit);

        Intent mIntent1=getIntent();
        mIntent1.getParcelableExtra("DATA");

        ListView listView=(ListView) findViewById(R.id.lip);


        listView.setAdapter(new ProduitAdapter(ProduitActivity.this,R.layout.activity_produit, list));



    }
}
