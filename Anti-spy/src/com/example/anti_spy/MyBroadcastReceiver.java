package com.example.anti_spy;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.provider.Contacts.People;
import android.util.Log;
import android.widget.Toast;


public class MyBroadcastReceiver extends BroadcastReceiver {

	private NotificationManager mNotificationManager;
	private int SIMPLE_NOTFICATION_ID;
	
	@Override
	public void onReceive(Context context, Intent intent) {

		System.out.println("ghoooooooooooooooz<<<<<<<<<<<<<<<<<<");
		Toast.makeText(context, "ACTION_PACKAGE_REMOVED nima nima joonnnnnnn2222", Toast.LENGTH_LONG).show();
        mNotificationManager = (NotificationManager)context.getSystemService(Context.NOTIFICATION_SERVICE);
		Notification notifyDetails = new Notification(R.drawable.android,"Time Reset!",System.currentTimeMillis());
		PendingIntent myIntent = PendingIntent.getActivity(context, 0, new Intent(Intent.ACTION_VIEW, People.CONTENT_URI), 0);
		notifyDetails.setLatestEventInfo(context, "Time has been Reset", "Click on me to view Contacts", myIntent);
		notifyDetails.flags |= Notification.FLAG_AUTO_CANCEL;
		notifyDetails.flags |= Notification.DEFAULT_SOUND;
		mNotificationManager.notify(SIMPLE_NOTFICATION_ID, notifyDetails);
		Log.i(getClass().getSimpleName(),"Sucessfully Changed Time");

	}

}