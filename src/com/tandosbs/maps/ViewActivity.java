package com.tandosbs.maps;

import com.google.android.gms.maps.MapFragment;

import android.app.Activity;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.util.Log;
import android.widget.RelativeLayout;

public class ViewActivity extends Activity {
	
	@Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        Log.d("MyMessages", "in ViewActivity.onCreate");
       
        RelativeLayout mainLayout = new RelativeLayout(this);
        mainLayout.setId(123);
        setContentView(mainLayout);
 
        Log.d("MyMessages", "ViewActivity Before newInstance");
        MapFragment frag = MapFragment.newInstance();
        Log.d("MyMessages", "in ViewActivity After newInstance");
        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
        fragmentTransaction.add(R.id.the_map, frag);
        fragmentTransaction.commit();
 
    }
}