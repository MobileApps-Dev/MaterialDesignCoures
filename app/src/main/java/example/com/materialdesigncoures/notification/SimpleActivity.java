package example.com.materialdesigncoures.notification;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import example.com.materialdesigncoures.R;

/**
 * Created by softbunch on 7/23/16.
 */
public class SimpleActivity extends AppCompatActivity {
    TextView textView, textView2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple);

        String title = getIntent().getExtras().getString("TITLE");
        String text = getIntent().getExtras().getString("TEXT");

        textView = (TextView) findViewById(R.id.textView);
        textView2 = (TextView) findViewById(R.id.textView2);

        textView.setText(title);
        textView2.setText(text);




    }
}
