package com.kpsharp.omdbsearch.ui.base;

import com.kpsharp.omdbsearch.exceptions.ViewAlreadyAttachedException;
import com.kpsharp.omdbsearch.exceptions.ViewNotAttachedException;

import android.support.annotation.NonNull;

public abstract class BasePresenter<T extends BaseMvp.BaseView> implements BaseMvp.BasePresenter<T> {

    // region Variables

    private T mBaseView;

    // endregion

    // region Abstract Methods

    /**
     * Use this to get the view that is attached to the presenter
     * Will throw a {@link ViewNotAttachedException} if there is no view
     * Use {@link #isAttached()}} to avoid this
     * @return The {@link com.kpsharp.omdbsearch.ui.base.BaseMvp.BaseView} attached to the presenter
     */
    @NonNull
    protected T getView() {

        if (mBaseView == null) {
            throw new ViewNotAttachedException();
        }

        return mBaseView;
    }

    // endregion

    // region BaseMvp.BasePresenter

    @Override
    public void attachView(@NonNull T view) throws ViewAlreadyAttachedException {

        if (mBaseView != null) {
            throw new ViewAlreadyAttachedException();
        }

        mBaseView = view;
    }

    @Override
    public void detachView() throws ViewNotAttachedException {

        if (mBaseView == null) {
            throw new ViewNotAttachedException();
        }

        mBaseView = null;
    }

    @Override
    public boolean isAttached() {

        return mBaseView != null;
    }

    // endregion
}
