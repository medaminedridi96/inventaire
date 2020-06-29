package com.dridimedamine.data.rest;

import com.dridimedamine.entites.Agent;
import com.dridimedamine.entites.AgentPost;
import com.dridimedamine.entites.Depot;
import com.google.gson.JsonElement;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiInterface {

    @GET("agent")
    Call<List<Agent>> getAgents();

    @GET("depot")
    Call<List<Depot>> getDepot();

    @POST("agent")
    Call<Agent> login(@Body AgentPost agentPost);
}
