package com.example.getgpsdemo;

import android.app.Activity;
import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class MainActivity extends Activity  {
	private LocationManager locationManager;
	private LocationListener locationListener;
	TextView textView01;
	TextView textView02;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		textView01 = (TextView) findViewById(R.id.TextView01);
		textView02 = (TextView) findViewById(R.id.TextView02);
		Log.i("msg","onLocationChanged經緯度AAA");
		UpdateLocation();
	}

	public void UpdateLocation() {
		locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
		locationListener = new LocationListener() {
			public void onLocationChanged(Location newLocation) {
				Double longitude = newLocation.getLongitude() * 1000000;
				Double latitude = newLocation.getLatitude() * 1000000;
				Log.i("msg", "X=" + longitude.intValue() + ", Y="+ latitude.intValue());
				textView01.setText("經度" + longitude);
				textView02.setText("緯度" + latitude);
			}

			@Override
			public void onProviderDisabled(String provider) {
				// TODO Auto-generated method stub

			}

			@Override
			public void onProviderEnabled(String provider) {
				// TODO Auto-generated method stub

			}

			@Override
			public void onStatusChanged(String provider, int status,
					Bundle extras) {
				// TODO Auto-generated method stub

			}
			
		};
		locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0,0, locationListener);
	}

	
	
}