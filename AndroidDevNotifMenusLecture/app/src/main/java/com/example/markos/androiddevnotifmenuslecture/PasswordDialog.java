package com.example.markos.androiddevnotifmenuslecture;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;

/**
 * Created by Markos on 27. 9. 2016.
 */

public class PasswordDialog extends DialogFragment {

    answerInterface ai;

    private String convert(int code){
        return getResources().getString(code);
    }

    public interface answerInterface {
        void acceptClicked(DialogFragment dialog, String answerText);
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            ai = (answerInterface) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString() + convert(R.string.notImplemented));
        }
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder adB = new AlertDialog.Builder(getActivity());
        LayoutInflater li = getActivity().getLayoutInflater();
        final View dialogView = li.inflate(R.layout.dialog_formular, null);
        adB.setView(dialogView)
        .setPositiveButton("Send", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                EditText et = (EditText) dialogView.findViewById(R.id.passwordTextView);
                String text = et.getText().toString();
                ai.acceptClicked(PasswordDialog.this, text);
            }
        });
        return adB.create();
    }
}
