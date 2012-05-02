package uk.co.roylines;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

public class Poller extends Service {

	private final String LOGTAG = "Travis: Poller";
	
	@Override
	public void onStart(Intent intent, int startId) {
		Log.i(LOGTAG, "Poller: onStart");
		super.onStart(intent, startId);
		
		Log.i(LOGTAG, "Poller: stopping self");
		stopSelf();
	}

	@Override
	public IBinder onBind(Intent intent) {
		return null;
	} 	
}