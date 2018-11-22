package com.picturest11.picturest.galleryhome;

import android.content.Context;

import com.picturest11.picturest.BasePresenter;
import com.picturest11.picturest.BaseView;
import com.picturest11.picturest.model.GalleryModel;

import java.util.List;

/**
 * Created by Siddharth on 21/11/18.
 */
public class GalleryContractor {

    interface View extends BaseView<Presenter> {

        void showInternetError();

        void showLoadedData(List<GalleryModel> galleryModel);

        void openFullImage(String userProfile);

        void stopLoading();
    }

    interface Presenter extends BasePresenter {

        void getPictures(Context mContext);
    }
}
