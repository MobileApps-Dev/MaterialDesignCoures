package example.com.materialdesigncoures.widget;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import example.com.materialdesigncoures.R;

/**
 * Created by softbunch on 7/25/16.
 */
public class CreateWidget extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.widget_create);

        Button button12 = (Button) findViewById(R.id.button12);
        Button button13 = (Button) findViewById(R.id.button13);
        Button button14 = (Button) findViewById(R.id.button14);

        button12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });


        button13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        button14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

    }
}
