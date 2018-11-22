package com.picturest11.picturest.galleryhome;


import android.content.Context;

import com.picturest11.picturest.AbstractPresenter;
import com.picturest11.picturest.util.AppUtils;
import com.picturest11.picturest.apiservice.RetrofitClient;
import com.picturest11.picturest.model.GalleryModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


/**
 * Created by Siddharth on 21/11/18.
 */
public class GalleryPresenter extends AbstractPresenter implements GalleryContractor.Presenter {

    private GalleryContractor.View mView;

    public GalleryPresenter(Context context, GalleryContractor.View view) {
        super(context, view);
        this.mView = view;
    }

    @Override
    public void start() {

    }

    @Override
    public void getPictures(Context mContext) {

        if (AppUtils.getINSTANCE().isInternetConnected(mContext)) {

            RetrofitClient.getInstance()
                    .getApi().doGetListResources()
                    .enqueue(new Callback<List<GalleryModel>>() {

                        @Override
                        public void onResponse(Call<List<GalleryModel>> call, Response<List<GalleryModel>> response) {
                            if (response.body() != null) {

                                mView.showLoadedData(response.body());
                            }
                        }

                        @Override
                        public void onFailure(Call<List<GalleryModel>> call, Throwable t) {

                        }
                    });

        } else {
            mView.showInternetError();

        }
    }

}
