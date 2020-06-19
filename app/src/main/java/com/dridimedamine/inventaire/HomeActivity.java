package com.dridimedamine.inventaire;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import com.Task;
import com.dridimedamine.adapter.AgentAdapter;
import com.dridimedamine.adapter.DepotAdapter;
import com.dridimedamine.entites.Agent;
import com.dridimedamine.entites.Depot;
import com.dridimedamine.entites.Produit;
import com.dridimedamine.remote.APIUtils;
import com.dridimedamine.remote.AgentService;
import com.dridimedamine.remote.DepotService;
import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeActivity extends AppCompatActivity {
    public static final String EXTRA_TEXT = "com.dridimedamine.inventaire.EXTRA_TEXT";

    DepotService depotService;
    List<Depot> list = new ArrayList<Depot>();
    Spinner spinner;
    Button btn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Button btn;
        spinner = (Spinner) findViewById(R.id.spinnerD);

        depotService = APIUtils.getDepotService();

        getDepotList();

        /*
        Agent ag = new Agent (1,"amine","drid","gfhfgdhg",222222);
        Agent ag2 = new Agent (1,"hedoi","drid","gfhfgdhg",222222);

        list.add(ag);
        list.add(ag2);
        listView.setAdapter(new AgentAdapter(MainActivity2.this,R.layout.agentslist, list));

         */


    }

    public void getDepotList() {
        Call<List<Depot>> call = depotService.getDepot();
        call.enqueue(new Callback<List<Depot>>() {
            @Override
            public void onResponse(Call<List<Depot>> call, Response<List<Depot>> response) {
                if (response.isSuccessful()) {
                    list = response.body();

                    Log.d("list", "onResponse: " + list);
                    ArrayAdapter<Depot> adapter = new ArrayAdapter<Depot>(HomeActivity.this, android.R.layout.simple_spinner_item, list);
                    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinner.setAdapter(adapter);
                    spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                            Depot depot = (Depot) parent.getSelectedItem();
                            displayUserData(depot);

                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> parent) {
                        }
                    });

                }
            }

            @Override
            public void onFailure(Call<List<Depot>> call, Throwable t) {
                Log.e("ERROR: ", t.getCause().getMessage());
            }
        });
    }

    public void getSelectedDepot(View v) {
        Depot depot = (Depot) spinner.getSelectedItem();
        displayUserData(depot);
    }

    private void displayUserData(Depot depot) {
        final String adresse = depot.getAdresse();
        String action = depot.getAction();
        final List<Produit> produit = depot.getProduit();


        String DepotData = "adresse: " + adresse + "\nAction: " + action + produit;
        Toast.makeText(this, DepotData, Toast.LENGTH_LONG).show();

        btn = (Button) findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mIntent = new Intent(HomeActivity.this, ComptageActivity.class);
                mIntent.putExtra(EXTRA_TEXT, adresse);
                startActivity(mIntent);

                Intent mIntent1 = new Intent(HomeActivity.this, ProduitActivity.class);
                mIntent1.putExtra("DATA", (Serializable) produit);
                startActivity(mIntent1);

            }
        });

    }


}

