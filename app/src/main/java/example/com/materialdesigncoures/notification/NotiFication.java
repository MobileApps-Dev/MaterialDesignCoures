package example.com.materialdesigncoures.notification;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import example.com.materialdesigncoures.R;
import example.com.materialdesigncoures.notification.custom.NotiFicationCustom;
import example.com.materialdesigncoures.widget.CreateWidget;

/**
 * Created by softbunch on 7/23/16.
 */
public class NotiFication extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.notify_main);

        Button button10 = (Button) findViewById(R.id.button10);
        Button button11 = (Button) findViewById(R.id.button11);
        Button appWidget = (Button) findViewById(R.id.app);

        button10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(NotiFication.this, NotificationMain.class);
                startActivity(intent);
            }
        });

        button11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(NotiFication.this, NotiFicationCustom.class);
                startActivity(intent);
            }
        });

        appWidget.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(NotiFication.this, CreateWidget.class);
                startActivity(intent);
            }
        });
    }
}
