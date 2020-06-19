package com.dridimedamine.data.rest;

import com.dridimedamine.entites.Agent;
import com.dridimedamine.entites.Depot;

import java.util.List;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.http.GET;

public interface ApiInterface {

    @GET("agent")
    Call<List<Agent>> getAgents();

    @GET("depot")
    Call<List<Agent>> getDepot();

}
