package ru.production.ssobolevsky.fragmenttest;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

/**
 * Created by pro on 18.06.2018.
 */

public class MyBroadcastReceiver extends BroadcastReceiver {

    public static final String DATA = "VALUE";


    private ViewCallback mViewCallback;

    public MyBroadcastReceiver(ViewCallback viewCallback) {
        mViewCallback = viewCallback;
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        this.mViewCallback.onTextChanged(intent.getStringExtra(DATA));
    }
}
