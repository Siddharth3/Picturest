package com.picturest11.picturest;

import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.LifecycleObserver;
import android.arch.lifecycle.LifecycleOwner;
import android.arch.lifecycle.OnLifecycleEvent;
import android.content.Context;

/**
 * Created by Siddharth on 21/11/18.
 */
public abstract class AbstractPresenter implements BasePresenter, LifecycleObserver {

    private BaseView view;
    private Context mContext;
    private Lifecycle mLifeCycle;

    public AbstractPresenter(Context context, BaseView view) {
        this.view = view;
        this.mContext = context;
        if (mContext != null) {
            LifecycleOwner owner = (LifecycleOwner) context;
            this.mLifeCycle = owner.getLifecycle();
            mLifeCycle.addObserver(this);
        }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public void onDestroy() {

        if (mLifeCycle != null)
            mLifeCycle.removeObserver(this);
    }
}
