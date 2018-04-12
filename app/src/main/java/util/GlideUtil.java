package util;

import android.databinding.BindingAdapter;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class GlideUtil {
    public static void getImgFromHttp(String url, ImageView imageView){
        Glide.with(imageView.getContext().getApplicationContext()).load(url).into(imageView);
    }



}
