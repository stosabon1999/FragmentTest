package ru.production.ssobolevsky.fragmenttest;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

/**
 * Created by pro on 18.06.2018.
 */

public class MyService extends Service {

    private static final int MODE = START_NOT_STICKY;

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        new Thread(new Runnable() {
            @Override
            public void run() {
                int i = 0;
                while (i < 100) {
                    Intent broadcastIntent = new Intent(MainActivity.FILTER);
                    broadcastIntent.putExtra(MyBroadcastReceiver.DATA, i + "a");
                    sendBroadcast(broadcastIntent);
                    i++;
                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
        return MODE;
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    public static Intent newIntent(Context context) {
        Intent intent = new Intent(context, MyService.class);
        return intent;
    }
}
