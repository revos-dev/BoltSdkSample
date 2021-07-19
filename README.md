# BoltSDKSample
A Sample app demonstrating the boltsdk api usage.

# sync the library from app level build.gradle
implementation 'in.revos.android:boltCore:1.0.34'

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