package com.dridimedamine.remote;



public class APIUtils {
    private APIUtils(){};

    public static final String API_URL="http://45aa462a4a64.ngrok.io/api/";

    public static AgentService getAgentService(){
        return RetrofitClient.getClient(API_URL).create(AgentService.class);
    }
    public static DepotService getDepotService(){
        return RetrofitClient.getClient(API_URL).create(DepotService.class);
    }
}
