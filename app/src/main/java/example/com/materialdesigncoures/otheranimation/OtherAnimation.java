package example.com.materialdesigncoures.otheranimation;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import example.com.materialdesigncoures.R;

/**
 * Created by softbunch on 7/2/16.
 */
public class OtherAnimation extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.other);
        Button tween = (Button) findViewById(R.id.tween);
        Button frameani = (Button) findViewById(R.id.frame);
        Button trans = (Button) findViewById(R.id.trans);
        Button inter = (Button) findViewById(R.id.inter);


        tween.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(OtherAnimation.this, Tween.class);
                startActivity(intent);
            }
        });

        frameani.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(OtherAnimation.this, FrameAni.class);
                startActivity(intent);
            }
        });

        trans.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(OtherAnimation.this, Translate.class);
                startActivity(intent);
            }
        });

        inter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(OtherAnimation.this, Interpolter.class);
                startActivity(intent);
            }
        });


    }
}
