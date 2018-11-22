package com.picturest11.picturest.fullimage;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.picturest11.picturest.R;
import com.picturest11.picturest.databinding.ActivityFullImageBinding;

import io.siddharth.picturest.imageloader.ImageLoader;

public class FullImageActivity extends AppCompatActivity {

    private Bundle extras;
    private String userProfile;
    ActivityFullImageBinding mActivityFullImageBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mActivityFullImageBinding = DataBindingUtil.setContentView(this,R.layout.activity_full_image);

        if (savedInstanceState == null) {
            extras = getIntent().getExtras();
            if(extras != null) {
                userProfile= extras.getString("userProfile");
                setImage();
            }
        }
    }

    private void setImage() {
        // Load image asynchronously without displaying it
        ImageLoader.createTask().web(userProfile).loadingRes(R.drawable.ic_empty)
                .failedRes(R.drawable.ic_error).into(mActivityFullImageBinding.imageViewFull).start();
    }
}
