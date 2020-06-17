package com.dridimedamine.inventaire;

import android.os.Bundle;

import com.dridimedamine.adapter.AgentAdapter;
import com.dridimedamine.entites.Agent;
import com.dridimedamine.remote.APIUtils;
import com.dridimedamine.remote.AgentService;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.util.Log;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity2 extends AppCompatActivity {

   AgentService agentService;
    List<Agent> list = new ArrayList<Agent>();
    ListView listView;
    TextView tv;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        tv =(TextView) findViewById (R.id.tv);
        listView = (ListView) findViewById(R.id.listView);

        agentService = APIUtils.getAgentService();

         getAgentsList();


        /*
        Agent ag = new Agent (1,"amine","drid","gfhfgdhg",222222);
        Agent ag2 = new Agent (1,"hedoi","drid","gfhfgdhg",222222);

        list.add(ag);
        list.add(ag2);
        listView.setAdapter(new AgentAdapter(MainActivity2.this,R.layout.agentslist, list));

         */






    }


    public void getAgentsList(){
        Call<List<Agent>> call = agentService.getAgents();
        call.enqueue(new Callback<List<Agent>>() {
            @Override
            public void onResponse(Call<List<Agent>> call, Response<List<Agent>> response) {
                if(response.isSuccessful()){
                    list = response.body();



                    Log.d("list", "onResponse: "+list);
                    listView.setAdapter(new AgentAdapter(MainActivity2.this,R.layout.agentslist, list));
                }
            }

            @Override
            public void onFailure(Call<List<Agent>> call, Throwable t) {
                Log.e("ERROR: ",t.getCause().getMessage());
            }
        });
    }
}