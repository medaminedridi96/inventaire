package com.dridimedamine.inventaire;

import android.os.Bundle;
import android.view.View;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.dridimedamine.adapter.ProduitAdapter;
import com.dridimedamine.entites.Depot;
import com.dridimedamine.entites.Produit;
import com.dridimedamine.global.Constants;
import com.dridimedamine.ui.activities.BaseActivity;

import java.util.ArrayList;
import java.util.List;

public class ProduitActivity extends BaseActivity {

    private RecyclerView productsRecyclerView;
    private List<Produit> produitList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_produit);

        initializeView();
        initialize();
    }

    private void initializeView() {

        backArrowButton.setVisibility(View.VISIBLE);
        backArrowButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        productsRecyclerView = findViewById(R.id.rv_products);
    }

    private void initialize() {

        if (getIntent() != null && getIntent().hasExtra(Constants.IntentKeys.SELECTED_DEPOT)
                && getIntent().getSerializableExtra(Constants.IntentKeys.SELECTED_DEPOT) != null) {
            Depot selectedDepot = (Depot) getIntent().getSerializableExtra(Constants.IntentKeys.SELECTED_DEPOT);
            if (selectedDepot != null) {
                produitList = new ArrayList<>();
                produitList.addAll(selectedDepot.getProducts());
                //populateProductsList(produitList);
                simulate(); //TODO remove
            }
        }

    }

    private void populateProductsList(List<Produit> produitList) {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        productsRecyclerView.setLayoutManager(linearLayoutManager);
        productsRecyclerView.setAdapter(new ProduitAdapter(produitList));
    }

    private void simulate() {
        List<Produit> produits = new ArrayList<>();
        produits.add(new Produit(1, "product 1", 99));
        produits.add(new Produit(2, "product 2", 12));
        produits.add(new Produit(3, "product 3", 121));
        produits.add(new Produit(4, "product 4", 0));
        produits.add(new Produit(5, "product 5", 50));
        produits.add(new Produit(6, "product 6", 612));

        populateProductsList(produits);
    }
}
