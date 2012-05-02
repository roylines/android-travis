package uk.co.roylines;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class Booter extends BroadcastReceiver {

	private final String LOGTAG = "Travis: Booter";
		
	@Override
	public void onReceive(Context context, Intent rIntent) {
		Log.i(LOGTAG, "Booter: onReceive");
		if (rIntent.getAction().equals(Intent.ACTION_BOOT_COMPLETED)) {
			AlarmManager am = (AlarmManager)context.getSystemService(Context.ALARM_SERVICE);
			Intent intent = new Intent(context, Poller.class);
			PendingIntent pIntent = PendingIntent.getService(context,0,intent, 0);
			long interval = AlarmManager.INTERVAL_FIFTEEN_MINUTES;
			long firstPoll = System.currentTimeMillis();
			am.setInexactRepeating(AlarmManager.RTC, firstPoll, interval, pIntent);
		}
	}
}
