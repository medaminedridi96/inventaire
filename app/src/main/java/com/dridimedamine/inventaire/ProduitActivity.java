package com.dridimedamine.inventaire;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
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


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.item_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.search_item:
                Toast.makeText(this, "item search selected", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.qr_item:
                Toast.makeText(this, "item QrCode selected", Toast.LENGTH_SHORT).show();
                return true;
            default:return super.onOptionsItemSelected(item);
        }

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
                produitList.addAll(selectedDepot.getProduit());
                populateProductsList(produitList);

                //simulate(); //TODO remove
            }
        }

    }




    private void populateProductsList(List<Produit> produitList) {

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        productsRecyclerView.setLayoutManager(linearLayoutManager);
        productsRecyclerView.setAdapter(new ProduitAdapter(produitList));


    }


}
