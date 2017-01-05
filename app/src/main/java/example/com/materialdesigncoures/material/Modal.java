package example.com.materialdesigncoures.material;

import java.util.ArrayList;

import example.com.materialdesigncoures.R;

/**
 * Created by softbunch on 6/29/16.
 */
public class Modal {
    String title;
    String desc;
    int image;


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public static ArrayList<Modal> getData() {

        ArrayList<Modal> datalist = new ArrayList<Modal>();

        int[] images = getImages();
        for (int i = 0; i < images.length; i++) {
            Modal modal = new Modal();
            modal.setImage(images[i]);
            modal.setTitle("Daya" + i);
            datalist.add(modal);
        }


        return datalist;
    }

    private static int[] getImages() {

        int[] images = {
                R.drawable.aquarius_new,
                R.drawable.flame_150,
                R.drawable.enemy,
                R.drawable.capricorn_new1,
                R.drawable.aquarius_new,
                R.drawable.flame_150,
                R.drawable.aries_new,
                R.drawable.friend,
                R.drawable.rashi_150,
                R.drawable.cancer_new,
                R.drawable.cancer_new,
                R.drawable.rashi_150,
                R.drawable.capricorn_new1
        };
        return images;
    }
}
