package com.kamalan.simplemap;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;

public class MainActivity extends FragmentActivity {

    private static final String TAG = "MainActivity";
    private static final LatLng LATLNG_IRAN = new LatLng(32.379961, 54.005356);

    private GoogleMap googleMap;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Log.d(TAG, "***************************");
        Log.d(TAG, "*** Application started ***");
        Log.d(TAG, "***************************");

        setContentView(R.layout.activity_main);

        // Check that Google Play Services is available on the device at runtime to protect against error cases
        if(!isGooglePlayServicesAvailable())
            return;

        googleMap = ((SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map)).getMap();
        if(googleMap == null) {
            Log.e(TAG, "googleMap should not be null");
            return;
        }

        // Move camera on top of IRAN
        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(LATLNG_IRAN, 4));

        Log.i(TAG, "View created");
    }

    private boolean isGooglePlayServicesAvailable() {
        int status = GooglePlayServicesUtil.isGooglePlayServicesAvailable(getApplicationContext());
        if(status == ConnectionResult.SUCCESS) {
            //Success! Do what you want
            Log.i(TAG, "Google Play Services are Available");
            return true;
        }

        Log.e(TAG, "Google Play Services are not Available");
        return false;
    }
}
