package uk.co.roylines;

import roboguice.service.RoboService;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

public class CheckService extends RoboService{

	private final static String TAG = "Travis CheckService";
	
	@Override
	public void onStart(Intent intent, int startId) {
		Log.i(TAG, "onStart");
		super.onStart(intent, startId);
		
		Log.i(TAG, "stopping");
		stopSelf();
	}

	@Override
	public IBinder onBind(Intent intent) {
		return null;
	} 	
}