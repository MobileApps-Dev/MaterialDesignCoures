package example.com.materialdesigncoures.material;

import android.annotation.TargetApi;
import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.transition.Slide;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;

import example.com.materialdesigncoures.R;

/**
 * Created by softbunch on 7/1/16.
 */
@TargetApi(Build.VERSION_CODES.LOLLIPOP)
public class AnimationMaterial extends AppCompatActivity implements View.OnClickListener {
    Button button1, button2, button3, button4, button5, button6, button7, button8, button9;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.animation);


        button1 = (Button) findViewById(R.id.button);
        button2 = (Button) findViewById(R.id.button2);
        button3 = (Button) findViewById(R.id.button3);
        button4 = (Button) findViewById(R.id.button4);
        button5 = (Button) findViewById(R.id.button5);
        button6 = (Button) findViewById(R.id.button6);
        button7 = (Button) findViewById(R.id.button7);
        button8 = (Button) findViewById(R.id.button8);
        button9 = (Button) findViewById(R.id.button9);

        button1.setOnClickListener(AnimationMaterial.this);
        button2.setOnClickListener(AnimationMaterial.this);
        button3.setOnClickListener(AnimationMaterial.this);
        button4.setOnClickListener(AnimationMaterial.this);
        button5.setOnClickListener(AnimationMaterial.this);
        button6.setOnClickListener(AnimationMaterial.this);
        button7.setOnClickListener(AnimationMaterial.this);
        button8.setOnClickListener(AnimationMaterial.this);
        button9.setOnClickListener(AnimationMaterial.this);

        /** Check Android Version Code **/
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            setUpWindowAnimation();
        }


    }

    private void setUpWindowAnimation() {
        Slide slide = new Slide();
        slide.setSlideEdge(Gravity.LEFT);
        slide.setDuration(1000);
        getWindow().setReenterTransition(slide);
        getWindow().setExitTransition(slide);
        getWindow().setAllowReturnTransitionOverlap(false);

    }


    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.button3:
                Intent intent = new Intent(AnimationMaterial.this, MainActivity.class);
                intent.putExtra("TYPE", Constant.AnimType.explodejava);
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(AnimationMaterial.this);
                    startActivity(intent, options.toBundle());
                } else {
                    startActivity(intent);
                }

                break;

            case R.id.button4:
                Intent intent1 = new Intent(AnimationMaterial.this, MainActivity.class);
                intent1.putExtra("TYPE", Constant.AnimType.explodexml);
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    ActivityOptions options1 = ActivityOptions.makeSceneTransitionAnimation(AnimationMaterial.this);
                    startActivity(intent1, options1.toBundle());
                } else {
                    startActivity(intent1);
                }

                break;

            case R.id.button5:
                Intent intent2 = new Intent(AnimationMaterial.this, MainActivity.class);
                intent2.putExtra("TYPE", Constant.AnimType.sidejava);
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    ActivityOptions options2 = ActivityOptions.makeSceneTransitionAnimation(AnimationMaterial.this);
                    startActivity(intent2, options2.toBundle());
                } else {
                    startActivity(intent2);
                }
                break;


            case R.id.button6:
                Intent intent3 = new Intent(AnimationMaterial.this, MainActivity.class);
                intent3.putExtra("TYPE", Constant.AnimType.sidexml);
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    ActivityOptions options3 = ActivityOptions.makeSceneTransitionAnimation(AnimationMaterial.this);
                    startActivity(intent3, options3.toBundle());
                } else {
                    startActivity(intent3);
                }
                break;

            case R.id.button7:
                Intent intent4 = new Intent(AnimationMaterial.this, MainActivity.class);
                intent4.putExtra("TYPE", Constant.AnimType.fadejava);
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    ActivityOptions options4 = ActivityOptions.makeSceneTransitionAnimation(AnimationMaterial.this);
                    startActivity(intent4, options4.toBundle());
                } else {
                    startActivity(intent4);
                }

                break;

            case R.id.button8:
                Intent intent5 = new Intent(AnimationMaterial.this, MainActivity.class);
                intent5.putExtra("TYPE", Constant.AnimType.fadexml);
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    ActivityOptions options5 = ActivityOptions.makeSceneTransitionAnimation(AnimationMaterial.this);
                    startActivity(intent5, options5.toBundle());
                } else {
                    startActivity(intent5);
                }

                break;

            case R.id.button9:
                Intent intent6 = new Intent(AnimationMaterial.this, SharedElement.class);
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    ActivityOptions options6 = ActivityOptions.makeSceneTransitionAnimation(AnimationMaterial.this, button9, "image");
                    startActivity(intent6, options6.toBundle());
                } else {
                    startActivity(intent6);
                }
                break;

        }


    }
}
