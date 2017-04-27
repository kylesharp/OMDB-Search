package com.kpsharp.omdbsearch.util.image;

import android.widget.ImageView;

public interface ImageUtil {

    void loadImage(ImageView imageView, String url);

    void loadImage(ImageView imageView, String url, int placeholderResId);
}
