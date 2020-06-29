package com.dridimedamine.inventaire;

import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.dridimedamine.data.rest.ApiClient;
import com.dridimedamine.entites.Agent;
import com.dridimedamine.entites.AgentPost;
import com.dridimedamine.listener.OnItemClicked;
import com.dridimedamine.adapter.ProduitAdapter;
import com.dridimedamine.entites.Depot;
import com.dridimedamine.entites.Produit;
import com.dridimedamine.global.Constants;
import com.dridimedamine.ui.activities.BaseActivity;
import com.dridimedamine.ui.view.RequestDialog;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProduitActivity extends BaseActivity implements OnItemClicked {

    private RecyclerView productsRecyclerView;
    private List<Produit> produitList;

    private RequestDialog requestDialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_produit);

        initializeView();
        initialize();

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.item_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.search_item:
                Toast.makeText(this, "item search selected", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.qr_item:
                Toast.makeText(this, "item QrCode selected", Toast.LENGTH_SHORT).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
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
        productsRecyclerView.setAdapter(new ProduitAdapter(produitList, this));


    }


    @Override
    public void onItemClicked(Produit produit) {
        requestDialog = new RequestDialog(this, R.string.app_name, R.string.ok, R.string.cancel, new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                postValue(requestDialog.getEditTextValue().toString()); //TODO
            }
        });
    }

    private void postValue(String value) {

        if (Utils.isNetworkAvailable(this)) {

            showProgressBar();
            //TODO TASNA3 EL OBJET ELLI BECH TPOSTIH KIMA FI POSTMAN
            Call call = ApiClient.getClient().postValue(value);
            call.enqueue(new Callback() {
                @Override
                public void onResponse(@NotNull Call call, @NotNull Response response) {
                    switch (response.code()) {
                        case Constants.HttpResponses.CODE_OK:
                            if (response.body() != null) {
                                hideProgressBar();
                                //TODO reponse ok
                                requestDialog.dismiss();
                            } else {
                                handleError();
                            }
                            break;

                        default:
                            handleError();
                            break;
                    }
                }

                @Override
                public void onFailure(Call call, Throwable t) {
                    handleError();
                }
            });


        } else {
            hideProgressBar();
            showErrorDialog(getString(R.string.check_network));
        }
    }
}
