package com.kpsharp.omdbsearch.util.image;

import com.bumptech.glide.Glide;

import android.content.Context;
import android.widget.ImageView;

public class ImageUtilImpl implements ImageUtil {

    private Context mContext;

    public ImageUtilImpl(Context context) {

        mContext = context;
    }

    @Override
    public void loadImage(ImageView imageView, String url) {

        loadImage(imageView, url, 0);
    }

    @Override
    public void loadImage(ImageView imageView, String url, int placeholderResId) {

        Glide.with(mContext)
                .load(url)
                .fitCenter()
                .placeholder(placeholderResId)
                .crossFade()
                .into(imageView);
    }
}
