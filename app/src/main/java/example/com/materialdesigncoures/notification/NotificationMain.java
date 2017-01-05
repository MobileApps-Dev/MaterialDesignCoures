package example.com.materialdesigncoures.notification;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

import example.com.materialdesigncoures.R;

/**
 * Created by softbunch on 7/12/16.
 */
public class NotificationMain extends AppCompatActivity {
    int NOTIFY_ID = 1;
    int NOTIFY_COUNT = 1;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.notification);

        /** Simple Notification  **/
        Button notify = (Button) findViewById(R.id.notify);
        notify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String title = "Test Demo";
                String text = "Make a notification ";

                /** Create the intent to display text in an Activity **/
                Intent intent = new Intent(NotificationMain.this, SimpleActivity.class);
                intent.setAction("NOTIFY");
                intent.putExtra("TITLE", title);
                intent.putExtra("TEXT", text);

                /** Create builder with basic notification **/
                NotificationCompat.Builder builder = initBasicBuilder(title, text, intent);
                /** Construct the notification **/
                Notification notification = builder.build();

                /** Display the Notification **/
                NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
                notificationManager.notify(NOTIFY_ID, notification);
            }
        });

        /** Simple Notification  with Large Icon **/
        Button notifyPersonal = (Button) findViewById(R.id.notify_personal);
        notifyPersonal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String title = "Test Demo";
                String text = "Make a notification ";
                /** Create the intent to display text in an Activity **/
                Intent intent = new Intent(NotificationMain.this, SimpleActivity.class);
                intent.setAction("NOTIFY");
                intent.putExtra("TITLE", title);
                intent.putExtra("TEXT", text);

                /** Create builder with basic notification **/
                NotificationCompat.Builder builder = initBasicBuilder(title, text, intent);

                /** Make  personal **/
                builder.setLargeIcon(BitmapFactory.decodeResource(getResources(), R.drawable.notify2));

                /** Construct the notification **/
                Notification notification = builder.build();

                /** Display the Notification **/
                NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
                notificationManager.notify(NOTIFY_ID, notification);

            }
        });

        /** Multipal  Notification  **/
        Button notifyMulti = (Button) findViewById(R.id.notify_multi);
        notifyMulti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String title = "Test Demo";
                String text = "Multipal Notification ";

                String detailtext1 = "Following are the device token update API details. ";
                String detailtext2 = "Make a notification ";
                ++NOTIFY_COUNT;

                ArrayList<String> list = new ArrayList<String>();
                list.add(detailtext1);
                list.add(detailtext2);

                /** Create the intent to display text in an Activity **/
                Intent intent = new Intent(NotificationMain.this, MultipalNotification.class);
                intent.setAction("NOTIFY");
                intent.putExtra("TITLE", title);
                intent.putExtra("TEXTARRAY", list);

                /** Create builder with basic notification **/
                NotificationCompat.Builder builder = initBasicBuilder(title, text, intent);

                /** Make  personal **/
                builder.setLargeIcon(BitmapFactory.decodeResource(getResources(), R.drawable.notify2))
                        .setNumber(NOTIFY_COUNT)
                        .setTicker("You Recived Msg");

                /** Construct the notification **/
                Notification notification = builder.build();

                /** Display the Notification **/
                NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
                //     notificationManager.notify(NOTIFY_ID + NOTIFY_COUNT, notification);
                notificationManager.notify(NOTIFY_ID, notification);
            }
        });

        /** Simple Notification with Big Text **/
        Button notifyBigText = (Button) findViewById(R.id.notify_big_text);
        notifyBigText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String title = "Big Test Demo";
                String summary = "The China-based tech company Xiaomi  ";
                String text = "The Redmi Pro is believed to be available at a price of 1499 yuan (approximately Rs 15,000). ";
                /** Create the intent to display text in an Activity **/
                Intent intent = new Intent(NotificationMain.this, SimpleActivity.class);
                intent.setAction("NOTIFY");
                intent.putExtra("TITLE", title);
                intent.putExtra("TEXT", text);

                /** Create builder with basic notification **/
                NotificationCompat.Builder builder = initBasicBuilder(title, text, intent);

                /** Big Text **/
                NotificationCompat.BigTextStyle bigTextStyle = new NotificationCompat.BigTextStyle();
                bigTextStyle.setBigContentTitle(title)
                        .setSummaryText(summary)
                        .bigText(text);
                builder.setStyle(bigTextStyle);


                /** Make  personal **/
                builder.setLargeIcon(BitmapFactory.decodeResource(getResources(), R.drawable.notify2));

                /** Construct the notification **/
                Notification notification = builder.build();

                /** Display the Notification **/
                NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
                notificationManager.notify(NOTIFY_ID, notification);
            }
        });

        /** Big Image Display in Notification **/
        Button notifyBigImg = (Button) findViewById(R.id.notify_big_img);
        notifyBigImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String title = "Big Test Demo";
                String text = "The Redmi Pro is believed to be available at a price of 1499 yuan (approximately Rs 15,000). ";
                String summary = "The China-based tech company Xiaomi  ";

                /** Create the intent to display text in an Activity **/
                Intent intent = new Intent(NotificationMain.this, SimpleActivity.class);
                intent.setAction("NOTIFY");
                intent.putExtra("TITLE", title);
                intent.putExtra("TEXT", text);

                /** Create builder with basic notification **/
                NotificationCompat.Builder builder = initBasicBuilder(title, text, intent);

                /** Big Picture **/
                NotificationCompat.BigPictureStyle bigPictureStyle = new NotificationCompat.BigPictureStyle();
                bigPictureStyle.setBigContentTitle(title)
                        .setSummaryText(summary)
                        .bigPicture(BitmapFactory.decodeResource(getResources(),R.drawable.pictur));
                builder.setStyle(bigPictureStyle);

                /** Make  personal **/
                builder.setLargeIcon(BitmapFactory.decodeResource(getResources(), R.drawable.notify2));

                /** Construct the notification **/
                Notification notification = builder.build();

                /** Display the Notification **/
                NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
                notificationManager.notify(NOTIFY_ID, notification);

            }
        });


    }

    private NotificationCompat.Builder initBasicBuilder(String title, String text, Intent intent) {
        NotificationCompat.Builder builder = new NotificationCompat.Builder(NotificationMain.this);
        builder.setSmallIcon(R.mipmap.ic_launcher)
                .setContentTitle(title)
                .setContentText(text);

        if (intent != null) {
            PendingIntent pendingIntent = PendingIntent.getActivity(NotificationMain.this, 0, intent, 0);
            builder.setContentIntent(pendingIntent);
        }


        return builder;
    }


}
