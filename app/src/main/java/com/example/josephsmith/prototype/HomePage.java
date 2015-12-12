package com.example.josephsmith.prototype;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.facebook.AccessToken;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.HttpMethod;
import com.parse.ParseException;
import com.parse.ParseFile;
import com.parse.ParseUser;
import com.parse.SaveCallback;

import org.json.JSONException;

import java.io.ByteArrayOutputStream;


public class HomePage extends Activity {
    ParseUser parseUser;
    String email, name;
    TextView emailTextView, nameTextView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        emailTextView = (TextView) findViewById(R.id.emailTextView);
        nameTextView = (TextView) findViewById(R.id.nameTextView);

        getUserDetailsFromFB();

    }

    public void logOut (View view){
        //log user out
        ParseUser.logOut();
        ParseUser currentUser = ParseUser.getCurrentUser(); // this will now be null

        Intent intent = new Intent (this, MainActivity.class);
        startActivity(intent);
    }

    private void getUserDetailsFromFB() {
        new GraphRequest(
                AccessToken.getCurrentAccessToken(),
                "/me",
                null,
                HttpMethod.GET,
                new GraphRequest.Callback() {
                    public void onCompleted(GraphResponse response) {
           /* handle the result */
                        try {
                            email = response.getJSONObject().getString("email");
                            emailTextView.setText(email);
                            name = response.getJSONObject().getString("name");
                            nameTextView.setText(name);
                            Log.d("joe smith", "Try was called");
                           // saveNewUser();
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }
        ).executeAsync();
        //ProfilePhotoAsync profilePhotoAsync = new ProfilePhotoAsync(mFbProfile);
        //profilePhotoAsync.execute();
    }
}
