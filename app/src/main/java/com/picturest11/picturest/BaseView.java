package com.picturest11.picturest;

/**
 * Created by Siddharth on 21/11/18.
 */
public interface BaseView<T extends BasePresenter> {

    /**
     * Setter for presenter
     *view.startLoading(mContext.getResources().getString(R.string.please_wait_while_editing_alarm));
     * @param presenter
     */
    void setPresenter(T presenter);

    /**
     * Update UI when not internet connection
     */
    void showInternetError();
}
