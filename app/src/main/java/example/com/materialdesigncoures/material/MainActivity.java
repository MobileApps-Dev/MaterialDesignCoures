package example.com.materialdesigncoures.material;

import android.annotation.TargetApi;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.support.v7.widget.Toolbar;
import android.transition.Explode;
import android.transition.Fade;
import android.transition.Slide;
import android.transition.Transition;
import android.transition.TransitionInflater;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.Window;
import android.view.animation.AccelerateDecelerateInterpolator;

import example.com.materialdesigncoures.R;

public class MainActivity extends AppCompatActivity {

    Toolbar toolbar;
    RecyclerView recyclerView;
    Constant.AnimType type;

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        /** Check Android Version Code **/
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().requestFeature(Window.FEATURE_CONTENT_TRANSITIONS);
        }
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setAllowEnterTransitionOverlap(false);
        }


        toolbar = (Toolbar) findViewById(R.id.toolbar);
        //   setSupportActionBar(toolbar);

        //   getSupportActionBar().setTitle("Welcome");
        toolbar.setTitle("Welcome");
        toolbar.setSubtitle("Today");
        // toolbar.setNavigationIcon(R.mipmap.ic_launcher);

        /** Check Android Version Code **/
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
//            // toolbar.setElevation(10f);
//        } else {
//
//        }
        recyclerView = (RecyclerView) findViewById(R.id.recycleview);
        ReAdapter adapter = new ReAdapter(MainActivity.this, Modal.getData());
        recyclerView.setAdapter(adapter);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(MainActivity.this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        type = (Constant.AnimType) getIntent().getSerializableExtra("TYPE");

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
          //  setUpAnimation();
        }


        toolbar.inflateMenu(R.menu.main_menu);
        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {

                switch (item.getItemId()) {

                    case R.id.linear_vertical:
                        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(MainActivity.this);
                        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
                        recyclerView.setLayoutManager(linearLayoutManager);
                        break;

                    case R.id.linear_horizontal:

                        LinearLayoutManager linearLayoutManager1 = new LinearLayoutManager(MainActivity.this);
                        linearLayoutManager1.setOrientation(LinearLayoutManager.HORIZONTAL);
                        recyclerView.setLayoutManager(linearLayoutManager1);
                        break;

                    case R.id.grid:
                        GridLayoutManager gridLayoutManager = new GridLayoutManager(MainActivity.this, 2);
                        recyclerView.setLayoutManager(gridLayoutManager);

                        break;

                    case R.id.stargged_vertical:
                        StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
                        recyclerView.setLayoutManager(staggeredGridLayoutManager);
                        break;

                    case R.id.stargged_horizontal:
                        StaggeredGridLayoutManager staggeredGridLayoutManager1 = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.HORIZONTAL);
                        recyclerView.setLayoutManager(staggeredGridLayoutManager1);
                        break;
                }
                return true;
            }
        });

    }


    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    private void setUpAnimation() {

        switch (type) {

            case explodejava:
                Explode explodejava = new Explode();
                explodejava.setDuration(1000);
                getWindow().setEnterTransition(explodejava);
                break;

            case explodexml:
                Transition transition = TransitionInflater.from(MainActivity.this).inflateTransition(R.transition.explode);
                transition.setDuration(1000);
                getWindow().setEnterTransition(transition);
                break;

            case fadejava:
                Fade fade = new Fade();
                fade.setDuration(1000);
                getWindow().setEnterTransition(fade);
                break;

            case fadexml:
                Transition transition1 = TransitionInflater.from(MainActivity.this).inflateTransition(R.transition.fade);
                transition1.setDuration(1000);
                getWindow().setEnterTransition(transition1);
                break;

            case sidejava:
                Slide slide = new Slide();
                slide.setSlideEdge(Gravity.RIGHT);
                //slide.setSlideEdge(Gravity.LEFT);
                // slide.setSlideEdge(Gravity.TOP);
                //    slide.setSlideEdge(Gravity.BOTTOM);
                slide.setDuration(1000);
                slide.setInterpolator(new AccelerateDecelerateInterpolator());
                getWindow().setEnterTransition(slide);
                break;

            case sidexml:
                Transition transition2 = TransitionInflater.from(MainActivity.this).inflateTransition(R.transition.slide);
                transition2.setDuration(1000);
                getWindow().setEnterTransition(transition2);
                break;
        }

    }


//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        getMenuInflater().inflate(R.menu.main_menu, menu);
//        return true;
//
//    }


}
