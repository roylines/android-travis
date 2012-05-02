package uk.co.roylines;

import roboguice.receiver.RoboBroadcastReceiver;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class BootReceiver extends RoboBroadcastReceiver {
	private static final String TAG = "Travis BootReceiver";
			
	@Override
	protected void handleReceive(Context context, Intent intent) {
		super.handleReceive(context, intent);
		Log.i(TAG, "onReceive");
		
		if (intent.getAction().equals(Intent.ACTION_BOOT_COMPLETED)) {
			Log.i(TAG, "ACTION_BOOT_COMPLETED matched");
			
			AlarmManager am = (AlarmManager)context.getSystemService(Context.ALARM_SERVICE);
			Intent pollerIntent = new Intent(context, CheckService.class);
			PendingIntent pendingIntent = PendingIntent.getService(context, 0, pollerIntent, 0);
			
			long interval = AlarmManager.INTERVAL_FIFTEEN_MINUTES;
			long firstPoll = System.currentTimeMillis();
			am.setInexactRepeating(AlarmManager.RTC, firstPoll, interval, pendingIntent);
		}
	}
}
