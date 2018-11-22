package com.picturest11.picturest.apiservice;


import com.picturest11.picturest.model.GalleryModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Siddharth on 21/11/18.
 */
public interface ApiInterface {

    @GET("raw/wgkJgazE")
    Call<List<GalleryModel>> doGetListResources();

}

