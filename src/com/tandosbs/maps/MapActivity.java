package com.tandosbs.maps;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.unity3d.player.UnityPlayer;
import com.unity3d.player.UnityPlayerActivity;

public class MapActivity extends UnityPlayerActivity {
	
	@Override
	public void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
	}
	
	public void showAndroidView()
    {
        Log.d("MyMessages", "in showAndroidView");
        UnityPlayer.currentActivity.runOnUiThread(new Runnable()
        {
            public void run()
            {
                Log.d("MyMessages", "Running showAndroidView");
                Intent intent = new Intent(UnityPlayer.currentActivity.getApplicationContext(), ViewActivity.class);
                UnityPlayer.currentActivity.startActivity(intent);
            }
        });
    }
}