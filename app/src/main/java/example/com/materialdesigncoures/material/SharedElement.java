package example.com.materialdesigncoures.material;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;

import example.com.materialdesigncoures.R;

/**
 * Created by softbunch on 7/1/16.
 */
public class SharedElement extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().requestFeature(Window.FEATURE_CONTENT_TRANSITIONS);
        }
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sheard_elememt);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setAllowEnterTransitionOverlap(false);
        }
    }
}
