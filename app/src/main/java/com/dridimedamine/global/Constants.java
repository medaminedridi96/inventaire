package com.dridimedamine.global;

public class Constants {

    public static class Durations {
        public static final long READ_TIMEOUT = 30000;
        public static final long CONNECT_TIMEOUT = 30000;
    }

    public static class EndPoint {
        public static final String LOGIN_USER = ""; //TODO add endpoint for login
    }

    public static class HttpResponses {
        public static final int USER_OK = 201;
        public static final int CODE_OK = 200;
        public static final int NOT_FOUND = 404;
    }

    public static class IntentKeys {
        public static final String USERNAME = "username";
        public static final String SELECTED_DEPOT = "selected_depot";
    }

    public static class SharedPreferencesKeys {
        public static final String NAME = "nom";
        public static final String PASSWORD = "password";
    }


}
