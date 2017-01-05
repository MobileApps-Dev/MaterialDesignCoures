package example.com.materialdesigncoures.otheranimation;

import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import example.com.materialdesigncoures.R;

/**
 * Created by softbunch on 7/2/16.
 */
public class FrameAni extends AppCompatActivity {
    ImageView imageView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.frame);

         imageView = (ImageView) findViewById(R.id.frame_img);
        Button start = (Button) findViewById(R.id.frame_btn);
        imageView.setBackgroundResource(R.drawable.frame_anim);

        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AnimationDrawable animationDrawable = (AnimationDrawable) imageView.getBackground();

                if (animationDrawable.isRunning()) {
                    animationDrawable.stop();
                } else {
                    animationDrawable.stop();
                    animationDrawable.start();
                }
            }
        });


    }
}
