package example.com.materialdesigncoures.notification.custom;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.TaskStackBuilder;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RemoteViews;

import com.google.android.gms.common.api.GoogleApiClient;

import example.com.materialdesigncoures.R;

/**
 * Created by softbunch on 7/23/16.
 */
public class NotiFicationCustom extends AppCompatActivity {

    String ACTION_DISPLAY_FROM_NOTIFICATION = "example.com.materialdesigncoures.notification.custom";
    String COURSE_INDEX = "coure index";
    int NOTIFY_ID = 1;

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cus_notification);

        Button notify_course = (Button) findViewById(R.id.notify_course);
        Button notify_service = (Button) findViewById(R.id.notify_service);
        Button notify_custom = (Button) findViewById(R.id.notify_custom);

        notify_course.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ACTION_DISPLAY_FROM_NOTIFICATION);
                intent.putExtra(COURSE_INDEX, 0);


                TaskStackBuilder taskStackBuilder = TaskStackBuilder.create(NotiFicationCustom.this);
                taskStackBuilder.addNextIntentWithParentStack(intent);
                PendingIntent pendingIntent = taskStackBuilder.getPendingIntent(0, PendingIntent.FLAG_UPDATE_CURRENT);
//                PendingIntent pendingIntent = PendingIntent.getActivity(NotiFicationCustom.this, 0, intent, 0);

                NotificationCompat.Builder builder = new NotificationCompat.Builder(NotiFicationCustom.this);
                builder.setSmallIcon(R.mipmap.ic_launcher)
                        .setAutoCancel(true)
                        .setContentTitle("Course Notification")
                        .setContentText("Android Notification")
                        .setContentIntent(pendingIntent);

                Notification notification = builder.build();
                NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
                notificationManager.notify(NOTIFY_ID, notification);
            }
        });

        notify_service.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(NotiFicationCustom.this, ServiceNotification.class);
                intent.setAction(ServiceNotification.START_ACTION);
                startService(intent);
            }
        });

        notify_custom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                RemoteViews notiRemoteViews = new RemoteViews(NotiFicationCustom.this.getPackageName(), R.layout.custom_notification);

                Intent sotpIntent = ServiceNotification.getStopIntent(NotiFicationCustom.this);
                PendingIntent stopPendingIntent1 = PendingIntent.getService(NotiFicationCustom.this, 0, sotpIntent, 0);
                notiRemoteViews.setOnClickPendingIntent(R.id.stop, stopPendingIntent1);


                Intent startIntent = ServiceNotification.getStartIntent(NotiFicationCustom.this);
                PendingIntent startPendingIntent1 = PendingIntent.getService(NotiFicationCustom.this, 0, startIntent, 0);
                notiRemoteViews.setOnClickPendingIntent(R.id.start, startPendingIntent1);

                NotificationCompat.Builder builder = new NotificationCompat.Builder(NotiFicationCustom.this);
                builder.setSmallIcon(R.mipmap.ic_launcher)
                        .setContent(notiRemoteViews);

                Notification notification = builder.build();
                NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
                notificationManager.notify(NOTIFY_ID, notification);
            }
        });


    }


}
