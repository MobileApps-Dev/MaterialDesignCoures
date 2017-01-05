package example.com.materialdesigncoures.notification.custom;

import android.app.Notification;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.support.v4.app.NotificationCompat;
import android.widget.Toast;

import example.com.materialdesigncoures.R;

/**
 * Created by softbunch on 7/23/16.
 */
public class ServiceNotification extends Service {
    public static final String START_ACTION = "start";
    public static final String STOP_ACTION = "stop";

    public static final int SERVICE_NOTIFY_ID = 100;


    public static Intent getStopIntent(Context context) {
        Intent intent = new Intent(context, ServiceNotification.class);
        intent.setAction(ServiceNotification.STOP_ACTION);
        return intent;
    }

    public static Intent getStartIntent(Context context) {
        Intent intent = new Intent(context, ServiceNotification.class);
        intent.setAction(ServiceNotification.START_ACTION);
        return intent;
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        //return super.onStartCommand(intent, flags, startId);

        try {
            String ser_action = intent.getAction();

            if (START_ACTION.equalsIgnoreCase(ser_action)) {
                handleStart();
            } else if (STOP_ACTION.equalsIgnoreCase(ser_action)) {
                handleStop();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return START_NOT_STICKY;
    }

    private void handleStart() {
        Intent intent = new Intent(ServiceNotification.this, StopService.class);

        PendingIntent pendingIntent = PendingIntent.getActivity(ServiceNotification.this, 0, intent, 0);

        Intent sotpIntent = getStopIntent(this);
        PendingIntent stopPendingIntent1 = PendingIntent.getService(this, 0, sotpIntent, 0);

        NotificationCompat.Builder builder = new NotificationCompat.Builder(ServiceNotification.this);
        builder.setSmallIcon(R.mipmap.ic_launcher)
                .setContentTitle("Service ")
                .setContentText("Service Forground")
                .setContentIntent(pendingIntent)
                .addAction(R.drawable.close_circle, "Stop", stopPendingIntent1);

        Notification notification = builder.build();
        startForeground(SERVICE_NOTIFY_ID, notification);

        displayMessage("Start Service");

    }

    private void handleStop() {
        stopForeground(true);
        stopSelf();
        displayMessage("Stop Service");
    }

    private void displayMessage(String s) {
        //    LogHelper.Log(s);
        Toast.makeText(ServiceNotification.this, s, Toast.LENGTH_SHORT).show();
    }
}



