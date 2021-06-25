package com.boltsdk.sample;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import com.boltCore.android.sdk.BoltSDK;
import com.boltCore.android.sdk.StatusCallBack;

public class MainActivity extends AppCompatActivity {

    private static String TAG = MainActivity.class.getName();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BoltSDK.getInstance().initialize(MainActivity.this, "your_generated_api_key", "user_id", new StatusCallBack() {
            @Override
            public void onStatusChange(String s) {
                Log.d(TAG, "onStatusChange = " + s);
            }

            @Override
            public void onError(String s) {
                Log.d(TAG, "onError = " + s);
            }
        }, null, null, null, null, null, null);

        BoltSDK.getInstance().launchBolt();
    }
}
