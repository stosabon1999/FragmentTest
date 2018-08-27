package ru.production.ssobolevsky.fragmenttest;

import android.app.FragmentManager;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity  implements IActivityCallback{

    public static final String FILTER = "SOBOLEVSKY";

    private MyBroadcastReceiver mMyBroadcastReceiver;

    private String mTemporaryText;

    private IntentFilter mIntentFilter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        startService(MyService.newIntent(MainActivity.this));
    }

    @Override
    protected void onResume() {
        super.onResume();
        registerReceiver(mMyBroadcastReceiver, mIntentFilter);
    }

    @Override
    protected void onStop() {
        super.onStop();
        unregisterReceiver(mMyBroadcastReceiver);
    }

    private void init() {
        mMyBroadcastReceiver = new MyBroadcastReceiver(new ViewCallBackImpl());
        mIntentFilter = new IntentFilter(FILTER);
    }

    @Override
    public void sendData(String text) {
        mTemporaryText = text;
    }

    public String getText() {
        return mTemporaryText;
    }

    private class ViewCallBackImpl implements ViewCallback {

        @Override
        public void onTextChanged(String newText) {
            Fragment fragment = getSupportFragmentManager()
                    .findFragmentById(R.id.f_text_view);
            ((BlankFragment) fragment).setEditText(newText);
        }
    }
}
