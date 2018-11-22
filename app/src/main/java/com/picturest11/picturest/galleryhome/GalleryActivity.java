package com.picturest11.picturest.galleryhome;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;


import com.picturest11.picturest.R;
import com.picturest11.picturest.databinding.ActivityGalleryBinding;
import com.picturest11.picturest.fullimage.FullImageActivity;
import com.picturest11.picturest.handlers.OnItemClickListener;
import com.picturest11.picturest.model.GalleryModel;

import java.util.List;

import io.siddharth.picturest.imageloader.ImageLoader;

/**
 * Created by Siddharth on 21/11/18.
 */
public class GalleryActivity extends AppCompatActivity implements GalleryContractor.View, OnItemClickListener<String> {

    ActivityGalleryBinding mActivityGalleryBinding;
    private GalleryAdapterNew galleryAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mActivityGalleryBinding = DataBindingUtil.setContentView(this, R.layout.activity_gallery);

        // set a GridLayoutManager with default vertical orientation and 2 number of columns
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getApplicationContext(), 2);
        mActivityGalleryBinding.recyclerViewPictures.setLayoutManager(gridLayoutManager); // set LayoutManager to RecyclerView

        GalleryPresenter galleryPresenter = new GalleryPresenter(this, this);
        galleryPresenter.getPictures(this);

        /*
         * For handle Endless data
         */
        mActivityGalleryBinding.recyclerViewPictures.setOnLoadListener(() -> {
            //For calling data again and again
            galleryPresenter.getPictures(GalleryActivity.this);
        });

        /*
         * For handle pull down refresh list
         */
        mActivityGalleryBinding.swiperefresh.setOnRefreshListener(() -> {

            galleryAdapter.clearData();
            mActivityGalleryBinding.swiperefresh.setRefreshing(false);
        });

        mActivityGalleryBinding.recyclerViewPictures.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                if (dy > 0 && mActivityGalleryBinding.fab.getVisibility() == View.VISIBLE) {
                    mActivityGalleryBinding.fab.hide();
                } else if (dy < 0 && mActivityGalleryBinding.fab.getVisibility() != View.VISIBLE) {
                    mActivityGalleryBinding.fab.show();
                }
            }
        });

        mActivityGalleryBinding.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                ImageLoader.clearMemCache();//clear all
                ImageLoader.clearDiskCache(GalleryActivity.this);//clear all

                Toast.makeText(GalleryActivity.this,R.string.cache_cleared,Toast.LENGTH_LONG).show();
            }
        });

        // Initializing adapter
        initializeAdapter();

    }

    private void initializeAdapter() {
        galleryAdapter = new GalleryAdapterNew(this);
        mActivityGalleryBinding.recyclerViewPictures.setAdapter(galleryAdapter);
    }

    @Override
    public void setPresenter(GalleryContractor.Presenter presenter) {

    }

    @Override
    public void showInternetError() {
        Toast.makeText(this,R.string.connection_error,Toast.LENGTH_LONG).show();
    }

    /**
     * Displays loaded picture List
     *
     * @param galleryModel
     */
    @Override
    public void showLoadedData(List<GalleryModel> galleryModel) {
        galleryAdapter.addItems(galleryModel);
        stopLoading();
    }

    /**
     * To open next full page for image
     */
    @Override
    public void openFullImage(String userProfile) {

        Intent intent = new Intent(GalleryActivity.this,FullImageActivity.class);
        intent.putExtra("userProfile",userProfile);// data link send to next screen
        startActivity(intent);

    }

    /*
    * For stop loading of endless recycler view
     */
    @Override
    public void stopLoading() {
        mActivityGalleryBinding.recyclerViewPictures.setLoading(false);
    }

    /**
     * To handle onClick of any data from adapter
     */
    @Override
    public void onItemClick(String userProfile) {

        openFullImage(userProfile);
    }
}
