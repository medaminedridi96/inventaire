package com.dridimedamine.ui.activities;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.dridimedamine.data.rest.ApiClient;
import com.dridimedamine.global.Constants;
import com.dridimedamine.global.Utils;
import com.dridimedamine.inventaire.R;
import com.dridimedamine.manager.PreferenceManager;

import org.jetbrains.annotations.NotNull;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends BaseActivity {

    private PreferenceManager mSharedPreferences;

    private EditText usernameEditText;
    private EditText passwordEditText;
    private Button connectButton;
    private TextView forgetPasswordTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        initializeView();
        initialize();

        simulate(); //TODO to remove
    }

    private void simulate() {
        if (usernameEditText.getText().toString().isEmpty() && passwordEditText.getText().toString().isEmpty()) {
            connectButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    showProgressBar(); // TODO this activity extend BaseActivity where you can find this method
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            hideProgressBar();
                            mSharedPreferences.put(Constants.SharedPreferencesKeys.USERNAME, usernameEditText.getText().toString());
                            handleSuccess(null);
                        }
                    }, 1500);
                }
            });
        }
    }

    private void initialize() {
        mSharedPreferences = PreferenceManager.getInstance();
    }

    private void initializeView() {
        connectButton = findViewById(R.id.btn_connect);
        connectButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                requestLoginProcess();
            }
        });

        forgetPasswordTextView = findViewById(R.id.tv_forget_password);
        forgetPasswordTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TODO navigate to forget password screen
            }
        });

        usernameEditText = findViewById(R.id.et_pseudo);
        passwordEditText = findViewById(R.id.et_password);
    }


    private void requestLoginProcess() {
        /**
         * TODO check if internet is connected the call api for connection
         * the next implementation are mostly a simulation
         */

        if (Utils.isNetworkAvailable(this)) {
            String username = usernameEditText.getText().toString();
            String password = passwordEditText.getText().toString();

            if (isValidForm(username, password)) {
                showProgressBar();
                Call call = ApiClient.getClient().loginUser(username, password);
                call.enqueue(new Callback() {
                    @Override
                    public void onResponse(@NotNull Call call, @NotNull Response response) {
                        switch (response.code()) {
                            case Constants.HttpResponses.CODE_OK:
                                if (response.body() != null) {
                                    hideProgressBar();
                                    mSharedPreferences.put(Constants.SharedPreferencesKeys.USERNAME, username);
                                    handleSuccess(response.body());
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
            }


        } else {
            hideProgressBar();
            showErrorDialog(getString(R.string.check_network));
        }

    }

    private void handleError() {
        hideProgressBar();
        showErrorDialog(getString(R.string.error_server));
    }

    private void handleSuccess(Object body) {
        //TODO body is the response resulting from calling login api

        Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
        intent.putExtra(Constants.IntentKeys.USERNAME, "simulated value user");
        startActivity(intent);
        finish();
    }

    private boolean isValidForm(String username, String password) {

        boolean status = false;

        if (TextUtils.isEmpty(username) || TextUtils.isEmpty(password)) {
            showErrorDialog(getString(R.string.error_username_or_password));
        } else { //TODO else if (add others conditions)
            status = true;
        }

        return status;
    }
}