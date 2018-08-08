package com.example.android.flexitask;

import android.app.Application;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.os.Build;

/**
 * Class initailised once app is started
 * Created by rymcg on 8/08/2018.
 */

public class AppManager extends Application {
    public static final String CHANNEL_1_ID = "dailyNotification";

    @Override
    public void onCreate() {
        super.onCreate();

        createNotificationChannels();
    }
    /**Class checks if Android oreo*/
    private void createNotificationChannels(){
        //notification class not avalaible on lower API, but must be used if user is running API>=26
        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.O){
            NotificationChannel channel1 = new NotificationChannel(
                    CHANNEL_1_ID,
                    "Channel title user sees",
                    NotificationManager.IMPORTANCE_LOW
            );
            channel1.setDescription("New Notification Description for channel1");

            //create channels
            NotificationManager manager = getSystemService(NotificationManager.class);
            manager.createNotificationChannel(channel1);
            ///channels for a list

        }

    }
}
