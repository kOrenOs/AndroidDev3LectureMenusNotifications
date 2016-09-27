package com.example.markos.androiddevnotifmenuslecture;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private String convert(int code){
        return getResources().getString(code);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Bundle extras = getIntent().getExtras();
        if(extras != null) {
            String temp = extras.get(convert(R.string.extrasName)).toString();
            TextView tv = (TextView) findViewById(R.id.outputText);
            tv.setText(temp);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.option_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.action_exitApplication:
                exitApplication();
                return true;
            case R.id.action_notifications:
                callNotifications();
                return true;
            case R.id.action_dialogs:
                callDialogs();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void callNotifications(){
        Intent intent = new Intent(this, Notifications.class);
        startActivity(intent);
    }

    private void callDialogs(){
        Intent intent = new Intent(this, Dialogs.class);
        startActivity(intent);
    }

    private void exitApplication(){
        Intent intent = new Intent(Intent.ACTION_MAIN);
        intent.addCategory(Intent.CATEGORY_HOME);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }
}
