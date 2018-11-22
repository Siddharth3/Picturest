package com.picturest11.picturest.galleryhome;

import android.support.v7.widget.RecyclerView;

import com.picturest11.picturest.R;
import com.picturest11.picturest.handlers.OnItemClickListener;
import com.picturest11.picturest.model.GalleryModel;

import io.siddharth.picturest.imageloader.ImageLoader;
import com.picturest11.picturest.databinding.ItemListImageBinding;

/**
 * Created by Siddharth on 21/11/18.
 */
public class GalleryViewHolder extends RecyclerView.ViewHolder {

    public ItemListImageBinding mItemListImageBinding;
    private OnItemClickListener<String> onItemClickListener;

    /**
     * @param itemListImageBinding
     */
    public GalleryViewHolder(ItemListImageBinding itemListImageBinding,
                                                   OnItemClickListener<String> onItemClickListener) {
        super(itemListImageBinding.getRoot());
        this.mItemListImageBinding = itemListImageBinding;
        this.onItemClickListener = onItemClickListener;
    }

    /**
     * Binds and displays pictures
     *
     * @param galleryModel
     */
    public void bind(GalleryModel galleryModel) {

        String userName = galleryModel.getUser().getName();
        String userProfile = galleryModel.getUser().getProfileImage().getLarge();

        mItemListImageBinding.textViewName.setText(userName);
        // Load image asynchronously without displaying it
        ImageLoader.createTask().web(userProfile).loadingRes(R.drawable.ic_empty)
                .failedRes(R.drawable.ic_error).into(mItemListImageBinding.imageView).start();

        itemView.setOnClickListener(view -> {
            onItemClickListener.onItemClick(userProfile);
        });
    }

}
