package com.example.markos.androiddevnotifmenuslecture;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.TaskStackBuilder;
import android.content.Intent;
import android.os.Bundle;
import android.provider.CalendarContract;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

/**
 * Created by Markos on 26. 9. 2016.
 */

public class Notifications extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.notifications_activity);
    }

    private String convert(int code){
        return getResources().getString(code);
    }

    public void backPublicAction(View view){
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra(convert(R.string.extrasName), convert(R.string.msgNotif1));
        PendingIntent pendIntent = PendingIntent.getActivity(this, 100, intent, PendingIntent.FLAG_CANCEL_CURRENT);

        Notification notif = new Notification.Builder(this)
                .setCategory(ACTIVITY_SERVICE)
                .setContentTitle(convert(R.string.msgNotif1Title))
                .setContentText(convert(R.string.msgNotif1Text))
                .setAutoCancel(true)
                .setContentIntent(pendIntent)
                .setVisibility(Notification.VISIBILITY_PUBLIC)
                .setSmallIcon(R.drawable.back_pict_1)
                .setPriority(Notification.PRIORITY_HIGH)
                .setColor(150)
                .addExtras(intent.getBundleExtra(convert(R.string.extrasName)))
                .build();

        notif.flags = Notification.FLAG_AUTO_CANCEL;

        NotificationManager notifManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        notifManager.notify(0, notif);
    }

    public void openAnotherApplicationAction(View view){
        Intent intent = new Intent(Intent.ACTION_EDIT)
                .setType("vnd.android.cursor.item/event")
                .putExtra(CalendarContract.Events.CALENDAR_ID, 1000);

        PendingIntent pendIntent = PendingIntent.getActivity(this, 101, intent, PendingIntent.FLAG_ONE_SHOT);

        Notification notif = new Notification.Builder(this)
                .setCategory(Notification.CATEGORY_SERVICE)
                .setContentTitle(convert(R.string.msgNotif2Title))
                .setContentText(convert(R.string.msgNotif2Text))
                .setAutoCancel(true)
                .setContentIntent(pendIntent)
                .setVisibility(Notification.VISIBILITY_PUBLIC)
                .setSmallIcon(R.drawable.back_pict_3)
                .setPriority(Notification.PRIORITY_HIGH)
                .setColor(70)
                .build();

        notif.flags = Notification.FLAG_AUTO_CANCEL;

        NotificationManager notifManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        notifManager.notify(0, notif);
    }

    public void openHandingNotification(View view){
        Intent intent = new Intent(this, Dialogs.class);
        intent.putExtra(convert(R.string.extrasName), convert(R.string.msgNotif3));
        PendingIntent pendIntent = PendingIntent.getActivity(this, 102, intent, PendingIntent.FLAG_ONE_SHOT);

        Intent intentSecond = new Intent(this, MainActivity.class);
        intentSecond.putExtra(convert(R.string.extrasName), convert(R.string.msgNotif3ToMain));
        TaskStackBuilder stackBuilder = TaskStackBuilder.create(this);
        stackBuilder.addParentStack(MainActivity.class);
        stackBuilder.addNextIntent(intentSecond);
        PendingIntent contentPendingIntent = stackBuilder.getPendingIntent(0, PendingIntent.FLAG_UPDATE_CURRENT);

        Notification notif = new Notification.Builder(this)
                .setCategory(Notification.CATEGORY_SERVICE)
                .setContentTitle(convert(R.string.msgNotif3Title))
                .setContentText(convert(R.string.msgNotif3Text))
                .addAction(R.drawable.back_pict_4, convert(R.string.dialogsLabel), pendIntent)
                .setAutoCancel(true)
                .setContentIntent(contentPendingIntent)
                .setVisibility(Notification.VISIBILITY_PUBLIC)
                .setSmallIcon(R.drawable.back_pict_2)
                .setPriority(Notification.PRIORITY_HIGH)
                .setColor(250)
                .build();

        notif.flags = Notification.FLAG_AUTO_CANCEL;

        NotificationManager notifManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        notifManager.notify(0, notif);
    }
}
