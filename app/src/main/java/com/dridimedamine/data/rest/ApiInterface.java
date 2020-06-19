package com.dridimedamine.data.rest;

import com.dridimedamine.entites.Agent;
import com.dridimedamine.entites.Depot;
import com.dridimedamine.global.Constants;
import com.google.gson.JsonElement;

import java.util.List;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ApiInterface {

    @GET("agent")
    Call<List<Agent>> getAgents();

    @GET("depot")
    Call<List<Depot>> getDepot();

    @FormUrlEncoded
    @POST(Constants.EndPoint.LOGIN_USER)
    Call<JsonElement> loginUser(String username, String password); // TODO not implemented yet
}
