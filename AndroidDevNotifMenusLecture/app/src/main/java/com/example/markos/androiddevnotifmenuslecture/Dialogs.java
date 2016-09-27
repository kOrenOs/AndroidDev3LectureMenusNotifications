package com.example.markos.androiddevnotifmenuslecture;

import android.app.DialogFragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Markos on 27. 9. 2016.
 */

public class Dialogs extends AppCompatActivity implements PasswordDialog.answerInterface, BasicDialog.basicDialogAnswer{

    private String convert(int code){
        return getResources().getString(code);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialogs_activity);
    }

    public void runBasicDialog(View view){
        BasicDialog bd = new BasicDialog();
        bd.show(getFragmentManager(), null);
    }

    public void runPasswordDialog(View view){
        PasswordDialog bd = new PasswordDialog();
        bd.show(getFragmentManager(), null);
    }

    @Override
    public void acceptClicked(DialogFragment dialog, String answerText) {
        TextView tv = (TextView) findViewById(R.id.answerTextView);
        tv.setText(convert(R.string.result)+answerText);
        Toast.makeText(getApplicationContext(), convert(R.string.result)+answerText, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void answer(DialogFragment dialog, String answerText) {
        TextView tv = (TextView) findViewById(R.id.answerTextView);
        tv.setText(convert(R.string.result)+answerText);
    }
}
