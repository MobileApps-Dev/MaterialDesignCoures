package example.com.materialdesigncoures.otheranimation;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

import example.com.materialdesigncoures.R;

/**
 * Created by softbunch on 7/2/16.
 */
public class Interpolter extends AppCompatActivity {
    ImageView imageView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.interpolter);

        imageView = (ImageView) findViewById(R.id.inter_img);
        Button start = (Button) findViewById(R.id.inter_btn);


        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Animation translateAnimation = AnimationUtils.loadAnimation(Interpolter.this, R.anim.inter_anim);
                imageView.startAnimation(translateAnimation);
            }
        });


    }
}