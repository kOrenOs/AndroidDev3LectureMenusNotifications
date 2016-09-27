package com.example.markos.androiddevnotifmenuslecture;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.Toast;

/**
 * Created by Markos on 27. 9. 2016.
 */

public class BasicDialog extends DialogFragment {

    public interface basicDialogAnswer{
        void answer(DialogFragment dialog, String answerText);
    }

    private String convert(int code){
        return getResources().getString(code);
    }

    basicDialogAnswer ai;

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            ai = (basicDialogAnswer) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString() + convert(R.string.notImplemented));
        }
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder adB = new AlertDialog.Builder(getActivity());
        adB.setTitle(convert(R.string.basicDialogTitle))
                .setMessage(convert(R.string.basicDialogMsg))
                .setPositiveButton(convert(R.string.basicDialogButton1), new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        Toast.makeText(getActivity(), convert(R.string.basicDialogAnswer1), Toast.LENGTH_SHORT).show();
                        ai.answer(BasicDialog.this, convert(R.string.basicDialogAnswer1));
                    }
                })
                .setNegativeButton(convert(R.string.basicDialogButton2), new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        Toast.makeText(getActivity(), convert(R.string.basicDialogAnswer2), Toast.LENGTH_SHORT).show();
                        ai.answer(BasicDialog.this, convert(R.string.basicDialogAnswer2));
                    }
                }).setNeutralButton(convert(R.string.basicDialogNoOne), new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                Toast.makeText(getActivity(), convert(R.string.basicDialogAnswerBoth), Toast.LENGTH_SHORT).show();
                ai.answer(BasicDialog.this, convert(R.string.basicDialogAnswerBoth));
            }
        });
        return adB.create();
    }
}
