package example.com.materialdesigncoures.otheranimation;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import example.com.materialdesigncoures.R;

/**
 * Created by softbunch on 7/2/16.
 */
public class Translate extends AppCompatActivity {
    ImageView imageView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.translate);

        imageView = (ImageView) findViewById(R.id.trans_img);
        Button start = (Button) findViewById(R.id.trans_btn);

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Translate.this, "clicked", Toast.LENGTH_SHORT).show();
            }
        });
        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TranslateAnimation translateAnimation = new TranslateAnimation(
                        Animation.ABSOLUTE, 0.0f,
                        Animation.ABSOLUTE, 0.0f,
                        Animation.ABSOLUTE, 0.0f,
                        Animation.ABSOLUTE, 200.0f
                );
                translateAnimation.setDuration(1000);
                translateAnimation.setFillAfter(true);
                imageView.startAnimation(translateAnimation);
            }
        });


    }
}