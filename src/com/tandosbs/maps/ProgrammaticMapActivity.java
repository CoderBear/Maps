package com.tandosbs.maps;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class ProgrammaticMapActivity extends FragmentActivity {
	private static final String MAP_FRAGMENT_TAG = "map";
    private GoogleMap mMap;
    private SupportMapFragment mMapFragment;
    
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Log.d("MyMessages", "in ViewActivity.onCreate");
		
		// It isn't possible to set a fragment's id programmatically so we set a tag instead and
        // search for it using that.
        mMapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentByTag(MAP_FRAGMENT_TAG);

        // We only create a fragment if it doesn't already exist.
        if (mMapFragment == null) {
            // To programmatically add the map, we first create a SupportMapFragment.
        	Log.d("MyMessages", "ViewActivity Before newInstance");
            mMapFragment = SupportMapFragment.newInstance();
            Log.d("MyMessages", "in ViewActivity After newInstance");

            // Then we add it using a FragmentTransaction.
            FragmentTransaction fragmentTransaction =
                    getSupportFragmentManager().beginTransaction();
            fragmentTransaction.add(android.R.id.content, mMapFragment, MAP_FRAGMENT_TAG);
            fragmentTransaction.commit();
        }

        // We can't be guaranteed that the map is available because Google Play services might
        // not be available.
        setUpMapIfNeeded();
	}
	@Override
	protected void onResume() {
		super.onResume();
		
		// In case Google Play services has since become available.
        setUpMapIfNeeded();
	}
    
	private void setUpMapIfNeeded() {
		// Do a null check to confirm that we have not already instantiated the map.
        if (mMap == null) {
            // Try to obtain the map from the SupportMapFragment.
            mMap = mMapFragment.getMap();
            // Check if we were successful in obtaining the map.
            if (mMap != null) {
                setUpMap();
            }
        }
	}
	private void setUpMap() {
		mMap.addMarker(new MarkerOptions().position(new LatLng(0, 0)).title("Marker"));
	}
    
}