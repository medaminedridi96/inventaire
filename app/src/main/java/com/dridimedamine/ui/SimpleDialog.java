package com.dridimedamine.ui;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.dridimedamine.inventaire.R;

public class SimpleDialog {

    private final AlertDialog mAlert;

    /**
     * Show a simple dialog with a title, message and button
     *
     * @param activity
     * @param message
     * @param resource
     */
    public SimpleDialog(Activity activity, int message, int resource) {

        View rootView = activity.getLayoutInflater().inflate(R.layout.dialog_simple, null, false);

        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        builder.setView(rootView);
        mAlert = builder.create();
        mAlert.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
        TextView messageTextView = (TextView) rootView.findViewById(R.id.message_tv);
        messageTextView.setText(activity.getString(message));
        Button button = (Button) rootView.findViewById(R.id.ok_btn);
        button.setText(activity.getString(resource));
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });

    }

    /**
     * Show a simple dialog with a title, message, a button and a listener
     *
     * @param activity
     * @param message
     * @param buttonText
     * @param listener
     */
    public SimpleDialog(final Activity activity, String message, String buttonText, final View.OnClickListener listener) {

        View rootView = activity.getLayoutInflater().inflate(R.layout.dialog_simple, null, false);

        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        builder.setView(rootView);
        builder.setCancelable(false);
        mAlert = builder.create();

        if (listener != null) {
            mAlert.setOnCancelListener(new DialogInterface.OnCancelListener() {

                @Override
                public void onCancel(DialogInterface dialog) {
                    listener.onClick(new View(activity));

                }
            });
        }

        TextView messageTextView = (TextView) rootView.findViewById(R.id.message_tv);
        messageTextView.setText(message);
        Button button = (Button) rootView.findViewById(R.id.ok_btn);
        button.setText(buttonText);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });

    }

    public SimpleDialog(final Activity activity, String message, String title, String buttonText, final View.OnClickListener listener) {

        View rootView = activity.getLayoutInflater().inflate(R.layout.dialog_simple, null, false);

        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        builder.setView(rootView);
        builder.setCancelable(false);
        mAlert = builder.create();

        if (listener != null) {
            mAlert.setOnCancelListener(new DialogInterface.OnCancelListener() {

                @Override
                public void onCancel(DialogInterface dialog) {
                    listener.onClick(new View(activity));

                }
            });
        }

        TextView messageTextView = (TextView) rootView.findViewById(R.id.message_tv);
        TextView titleTextView = (TextView) rootView.findViewById(R.id.title);
        titleTextView.setVisibility(View.VISIBLE);

        if(TextUtils.isEmpty(title)) {
            titleTextView.setText(activity.getString(R.string.app_name));
        } else {
            titleTextView.setText(title);
        }
        messageTextView.setText(message);
        Button button = (Button) rootView.findViewById(R.id.ok_btn);
        button.setText(buttonText);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });

    }

    /**
     * Show custom dialog
     */
    public void show() {
        mAlert.show();
    }

    /**
     * Dismiss custom dialog
     */
    public void dismiss() {
        mAlert.cancel();
    }
}
