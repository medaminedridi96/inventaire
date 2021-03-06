package com.dridimedamine.ui.activities;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;

import com.dridimedamine.inventaire.R;
import com.dridimedamine.manager.PreferenceManager;
import com.dridimedamine.ui.view.SimpleDialog;

public class BaseActivity extends AppCompatActivity {

    private PreferenceManager mPreferenceManager;

    public Toolbar mToolbar;
    public TextView toolbarTitle;
    public ImageButton backArrowButton;

    private ProgressDialog mProgressDialog;
    private SimpleDialog mSimpleDialog;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
    }



    @Override
    public void setContentView(@LayoutRes int layoutResID) {
        super.setContentView(layoutResID);

        mPreferenceManager = PreferenceManager.getInstance();
        initializeToolBar();
    }

    private void initializeToolBar() {
        mToolbar = (Toolbar) findViewById(R.id.toolbar);

        if (mToolbar != null) {
            toolbarTitle = mToolbar.findViewById(R.id.tv_toolbar_title);
            backArrowButton = mToolbar.findViewById(R.id.iv_arrow_back);
        }
    }

    public void showProgressBar() {
        if (!isFinishing()) {
            if (mProgressDialog == null) {
                mProgressDialog = new ProgressDialog(this, R.style.ProgressDialogStyle);
                mProgressDialog.setCancelable(false);
                mProgressDialog.setIndeterminateDrawable(ContextCompat.getDrawable(this, R.drawable.progress));
            }

            if (!mProgressDialog.isShowing()) {
                mProgressDialog.show();
            }
        }
    }

    public void hideProgressBar() {
        if (!isFinishing()) {
            if (mProgressDialog != null && mProgressDialog.isShowing()) {
                mProgressDialog.dismiss();
            }
        }
    }

    public void showErrorDialog(String message) {

        mSimpleDialog = new SimpleDialog(this, message, getString(R.string.ok), new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mSimpleDialog.dismiss();
            }
        });

        mSimpleDialog.show();

    }
}
