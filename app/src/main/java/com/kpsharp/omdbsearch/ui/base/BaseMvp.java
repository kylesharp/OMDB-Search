package com.kpsharp.omdbsearch.ui.base;

import com.kpsharp.omdbsearch.exceptions.ViewAlreadyAttachedException;
import com.kpsharp.omdbsearch.exceptions.ViewNotAttachedException;

import android.support.annotation.NonNull;

public interface BaseMvp {

    interface BaseView {

    }

    interface BasePresenter<T extends BaseView> {

        /**
         * Subscribes the presenter to the observables
         * If there is a view attached, the presenter will call methods on it as is necessary based on the observables emitting data
         * This should be called whenever the presenter first comes alive and any time it resumes (can be tied to Activity/Fragment lifecycle if desired)
         */
        void subscribeToObservables();

        /**
         * Unsubscribes the presenter from the observables
         * This should be called whenever the presenter is slept and when it is destroyed (can be timed to Activity/Fragment lifecycle if desired)
         */
        void unsubscribeFromObservables();

        /**
         * Attaches a view to this presenter
         * @param view The {@link BaseView} to attach
         * @throws ViewAlreadyAttachedException
         */
        void attachView(@NonNull T view) throws ViewAlreadyAttachedException;

        /**
         * Detaches the current view from this presenter
         * @throws ViewNotAttachedException Thrown if there is no view attached
         */
        void detachView() throws ViewNotAttachedException;

        /**
         * Checks to see if the presenter has a view attached
         * Use this with {@link #attachView(BaseView)} and {@link #detachView()} to avoid exceptions
         * @return True if there is a view attached, false if there is not
         */
        boolean isAttached();
    }
}
