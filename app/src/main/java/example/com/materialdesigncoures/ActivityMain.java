package example.com.materialdesigncoures;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import example.com.materialdesigncoures.material.AnimationMaterial;
import example.com.materialdesigncoures.notification.NotiFication;
import example.com.materialdesigncoures.otheranimation.OtherAnimation;

/**
 * Created by softbunch on 7/2/16.
 */
public class ActivityMain extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        Button material = (Button) findViewById(R.id.material);
        Button other = (Button) findViewById(R.id.other);
        Button notification = (Button) findViewById(R.id.notification);


        material.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ActivityMain.this, AnimationMaterial.class);
                startActivity(intent);
            }
        });

        other.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ActivityMain.this, OtherAnimation.class);
                startActivity(intent);
            }
        });

        notification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ActivityMain.this, NotiFication.class);
                startActivity(intent);
            }
        });
    }
}
