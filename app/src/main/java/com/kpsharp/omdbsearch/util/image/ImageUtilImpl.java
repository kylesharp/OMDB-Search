package com.kpsharp.omdbsearch.util.image;

import com.bumptech.glide.Glide;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.widget.ImageView;

public class ImageUtilImpl implements ImageUtil {

    // region Variables

    private Context mContext;

    // endregion

    // region Lifecycle

    public ImageUtilImpl(Context context) {

        mContext = context;
    }

    // endregion

    // region ImageUtil

    @Override
    public void loadImage(@NonNull ImageView imageView, @Nullable String url) {

        loadImage(imageView, url, 0);
    }

    @Override
    public void loadImage(@NonNull ImageView imageView, @Nullable String url, int placeholderResId) {

        url = url != null ? url : "";

        Glide.with(mContext)
                .load(url)
                .fitCenter()
                .placeholder(placeholderResId)
                .crossFade()
                .into(imageView);
    }

    // endregion
}
