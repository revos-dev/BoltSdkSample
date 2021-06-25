# BoltSDKSample
A Sample app demonstrating the boltsdk api usage.

# sync the library from app level build.gradle
implementation 'in.revos.android:boltCore:1.0.32'

# Add these permissions in AndroidManifest.xml

# Location permission is required to show nearby bolt chargers
```
<uses-permission android:name="android.permission.ACCESS_FINE_LOCATION" />
<uses-permission android:name="android.permission.ACCESS_COARSE_LOCATION"/>
<uses-permission android:name="android.permission.WAKE_LOCK"/>
```
# To show google maps and sync with backend api
```
<uses-permission android:name="android.permission.INTERNET"/>
```

# To pair with bolt charger and EV's within proximity
```
<uses-permission android:name="android.permission.BLUETOOTH_ADMIN" />
<uses-permission android:name="android.permission.BLUETOOTH" />
<uses-permission android:name="android.permission.ACCESS_NETWORK_STATE" />
<uses-permission android:name="android.permission.READ_PHONE_STATE" />
```

# To scan QR code with bolt charger and EV's
```
<uses-permission android:name="android.permission.CAMERA" />
<uses-feature android:name="android.hardware.camera.autofocus"/>
```

# Initialize bolt-sdk passing the activity context, auth-token, user-id
```
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
```