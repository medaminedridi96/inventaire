package com.dridimedamine.ui.activities;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import com.dridimedamine.data.rest.ApiClient;
import com.dridimedamine.entites.Depot;
import com.dridimedamine.entites.Produit;
import com.dridimedamine.global.Constants;
import com.dridimedamine.global.Utils;
import com.dridimedamine.inventaire.ProduitActivity;
import com.dridimedamine.inventaire.R;
import com.dridimedamine.ui.view.CustomSpinner;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeActivity extends BaseActivity implements AdapterView.OnItemSelectedListener {

    public static final String EXTRA_TEXT = "com.dridimedamine.inventaire.EXTRA_TEXT";

    private TextView usernameTextView;
    private CustomSpinner depositSpinner;
    private Button validateButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        initializeView();
        initialize();

    }


    private void initializeView() {

        toolbarTitle.setVisibility(View.VISIBLE);

        usernameTextView = findViewById(R.id.tv_username);
        depositSpinner = findViewById(R.id.spinner_deposit);
        depositSpinner.setOnItemSelectedListener(this);

        validateButton = findViewById(R.id.btn_validate);
        validateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Depot selectedDepot = (Depot) depositSpinner.getSelectedItem();

                navigateToPoductsActivity(selectedDepot);


                /*Intent mIntent = new Intent(HomeActivity.this, ComptageActivity.class);
                mIntent.putExtra(EXTRA_TEXT, adresse);
                startActivity(mIntent);

                Intent mIntent1 = new Intent(HomeActivity.this, ProduitActivity.class);
                mIntent1.putExtra("DATA", (Serializable) produit);
                startActivity(mIntent1);*/

            }
        });
    }

    private void navigateToPoductsActivity(Depot selectedDepot) {
        Intent intent = new Intent(HomeActivity.this, ProduitActivity.class);
        intent.putExtra(Constants.IntentKeys.SELECTED_DEPOT, selectedDepot);
        startActivity(intent);
    }

    private void initialize() {

        // TODO get data from login page
        if (getIntent().hasExtra(Constants.IntentKeys.USERNAME) && getIntent().getStringExtra(Constants.IntentKeys.USERNAME) != null) {
            String username = getIntent().getStringExtra(Constants.IntentKeys.USERNAME);
            usernameTextView.setText(username);
        }

        if (Utils.isNetworkAvailable(this)) {
            //getDepotList();
            simulate(); // TODO remove simulation
        } else {
            showErrorDialog(getString(R.string.check_network));
        }
    }

    private void simulate() {
        List<Produit> produits1 = new ArrayList<>();
        produits1.add(new Produit(1, "product 1", 99));
        produits1.add(new Produit(2, "product 2", 12));
        produits1.add(new Produit(3, "product 3", 121));

        List<Produit> produits2 = new ArrayList<>();
        produits2.add(new Produit(4, "product 4", 0));
        produits2.add(new Produit(5, "product 5", 50));
        produits2.add(new Produit(6, "product 6", 612));

        List<Produit> produits3 = new ArrayList<>();
        produits3.add(new Produit(7, "product 7", 190));
        produits3.add(new Produit(8, "product 8", 1211));
        produits3.add(new Produit(9, "product 9", 871));


        List<Depot> depots = new ArrayList<>();
        depots.add(new Depot(1, "address 1", "action 1", produits1));
        depots.add(new Depot(2, "address 2", "action 2", produits2));
        depots.add(new Depot(3, "address 3", "action 3", produits3));

        showProgressBar();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                populateDepositSpinner(depots);
            }
        }, 1500);

    }

    private void populateDepositSpinner(List<Depot> depots) {
        hideProgressBar();
        ArrayAdapter<Depot> depotArrayAdapter
                = new ArrayAdapter<>(this, R.layout.item_deposit, depots);
        depositSpinner.setAdapter(depotArrayAdapter);
        depositSpinner.setSelection(0);

    }

    /**
     * call getDepots api to return list of deposits
     */
    public void getDepotList() {

        showProgressBar();
        Call<List<Depot>> call = ApiClient.getClient().getDepot();

        call.enqueue(new Callback<List<Depot>>() {
            @Override
            public void onResponse(Call<List<Depot>> call, Response<List<Depot>> response) {

                switch (response.code()) {
                    case Constants.HttpResponses.CODE_OK:
                        if (response.body() != null) {
                            hideProgressBar();
                            populateDepositSpinner(response.body());
                        } else {
                            hideProgressBar();
                            showErrorDialog(getString(R.string.error_server));
                        }
                        break;

                    default:
                        hideProgressBar();
                        showErrorDialog(getString(R.string.error_server));
                        break;
                }
            }

            @Override
            public void onFailure(Call<List<Depot>> call, Throwable t) {
                hideProgressBar();
                showErrorDialog(getString(R.string.error_server));
            }
        });
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        switch (parent.getId()) {
            case R.id.spinner_deposit:
                Depot selectedDepot = (Depot) parent.getSelectedItem();
                //TODO check wherever to do on item selected
                // Sheet is not so clear
                break;

            default:
                break;
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        Log.i("INFO", "Nothing Selected");
    }
}

