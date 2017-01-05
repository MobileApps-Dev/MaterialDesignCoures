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
public class Tween extends AppCompatActivity implements Animation.AnimationListener {

    Animation alpha_anim;
    Animation scale_anim;
    Animation rotate_anim;
    Animation trans_anim;

    ImageView imageView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tween);

        Button alpha = (Button) findViewById(R.id.alpha);
        Button sacle = (Button) findViewById(R.id.scale);
        Button rotate = (Button) findViewById(R.id.rotate);
        Button trans = (Button) findViewById(R.id.trans);
        imageView = (ImageView) findViewById(R.id.image_anim);

        alpha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alpha_anim = AnimationUtils.loadAnimation(Tween.this, R.anim.alpha_anim);
                alpha_anim.setAnimationListener(Tween.this);
                imageView.startAnimation(alpha_anim);
            }
        });

        sacle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                scale_anim = AnimationUtils.loadAnimation(Tween.this, R.anim.scale_anim);
                scale_anim.setAnimationListener(Tween.this);
                imageView.startAnimation(scale_anim);
            }
        });

        rotate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rotate_anim = AnimationUtils.loadAnimation(Tween.this, R.anim.rotate_anim);
                rotate_anim.setAnimationListener(Tween.this);
                imageView.startAnimation(rotate_anim);
            }
        });

        trans.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                trans_anim = AnimationUtils.loadAnimation(Tween.this, R.anim.trans_anim);
                trans_anim.setAnimationListener(Tween.this);
                imageView.startAnimation(trans_anim);
            }
        });
    }

    @Override
    public void onAnimationStart(Animation animation) {

    }

    @Override
    public void onAnimationEnd(Animation animation) {

    }

    @Override
    public void onAnimationRepeat(Animation animation) {

    }
}
