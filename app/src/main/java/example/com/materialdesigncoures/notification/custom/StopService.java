package example.com.materialdesigncoures.notification.custom;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import example.com.materialdesigncoures.R;

/**
 * Created by softbunch on 7/23/16.
 */
public class StopService extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.stop_ser);
        Button button = (Button) findViewById(R.id.stop_ser);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent intent = new Intent(StopService.this,ServiceNotification.class);
//                intent.setAction(ServiceNotification.STOP_ACTION);

                Intent intent = ServiceNotification.getStopIntent(StopService.this);
                startService(intent);
            }
        });
    }
}
