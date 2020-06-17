package com.dridimedamine.inventaire;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    Button login;
    EditText username,mdp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        login =findViewById(R.id.login);
        username=findViewById(R.id.username);
        mdp=findViewById(R.id.mdp);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, HomeActivity.class);
                startActivity(intent);

            }
        });
    }
    public void login() {
        StringRequest request = new StringRequest(Request.Method.POST, "http://192.168.1.3/inventaire/login.php",
                new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                if (response.contains("1")){
                    startActivity(new Intent(getApplicationContext(),HomeActivity.class));
                }else {
                    Toast.makeText(getApplicationContext(),"check username or password",Toast.LENGTH_LONG).show();

                }


            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params =new HashMap<>();
                params.put("username",username.getText().toString());
                params.put("mdp",mdp.getText().toString());
                return params;
            }
        };
        Volley.newRequestQueue(this).add(request);
    }



    }

