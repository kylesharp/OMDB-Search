package com.kpsharp.omdbsearch.util.image;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.widget.ImageView;

public interface ImageUtil {

    /**
     * Loads an image from the url into the image view
     * @param imageView The target {@link ImageView} view to load into
     * @param url The {@link String} url of the image to load
     */
    void loadImage(@NonNull ImageView imageView, @Nullable String url);

    /**
     * Loads an image from the url into the image view with a local placeholder from {@link android.content.res.Resources}
     * @param imageView The target {@link ImageView} view to load into
     * @param url The {@link String} url of the image to load
     * @param placeholderResId The resource id of the placeholder image
     */
    void loadImage(@NonNull ImageView imageView, @Nullable String url, int placeholderResId);
}
