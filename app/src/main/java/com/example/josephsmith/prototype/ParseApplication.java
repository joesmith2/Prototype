package com.example.josephsmith.prototype;
import android.app.Application;
import com.parse.Parse;
import com.parse.ParseFacebookUtils;

/**
 * Created by Joseph.Smith on 02/12/2015.
 * This claass intiates parse but only once. This prevents the app from crashing when it is relaunched
 * The following line must be added to the AndroidManifest.xml right after the <application tag
 * android:name="com.example.josephsmith.prototype.ParseApplication"
 */
public class ParseApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        // Enable Local Datastore.
        Parse.enableLocalDatastore(this);
        Parse.initialize(this, "pCWREAFMJXI1IKslBP52UxLN8vuRF4UeCrq6WML7", "vmkApKlExoHknzO8pOLhEaXdUDUonc58hTdbw40Q");
        ParseFacebookUtils.initialize(this);
        // Initialize the SDK before executing any other operations,
        // especially, if you're using Facebook UI elements
    }
}