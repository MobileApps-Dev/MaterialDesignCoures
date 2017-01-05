package example.com.materialdesigncoures.notification;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

import example.com.materialdesigncoures.R;

/**
 * Created by softbunch on 7/23/16.
 */
public class MultipalNotification extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.multipal_notification);

        String title = getIntent().getExtras().getString("TITLE");
        ArrayList<String> notificationMulti = getIntent().getExtras().getStringArrayList("TEXTARRAY");

        ListView listView = (ListView) findViewById(R.id.listview);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                MultipalNotification.this,
                android.R.layout.simple_expandable_list_item_1,
                notificationMulti);

        listView.setAdapter(adapter);
    }
}
