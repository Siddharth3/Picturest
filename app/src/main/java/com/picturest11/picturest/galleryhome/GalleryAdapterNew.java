package com.picturest11.picturest.galleryhome;

import android.databinding.DataBindingUtil;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.picturest11.picturest.R;
import com.picturest11.picturest.util.ui.EndlessRecyclerView;
import com.picturest11.picturest.databinding.ItemListImageBinding;
import com.picturest11.picturest.handlers.OnItemClickListener;
import com.picturest11.picturest.model.GalleryModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Siddharth on 22/11/18.
 */
public class GalleryAdapterNew extends EndlessRecyclerView.Adapter<GalleryViewHolder> {

    private List<GalleryModel> galleryPictureList;
    private OnItemClickListener<String> onItemClickListener;
    ItemListImageBinding mItemListImageBinding;

    /**
     * Constructor to {@link GalleryAdapterNew}
     *
     * @param onItemClickListener called when User click on picture
     */
    public GalleryAdapterNew(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    /**
     * Adds pictures to the recycler view and performs notifyChange
     *
     * @param galleryModel
     */
    public void addItems(List<GalleryModel> galleryModel) {

        if (galleryPictureList == null) {
            galleryPictureList = new ArrayList<>();
        }

        galleryPictureList.addAll(new ArrayList<>(galleryModel));
        notifyDataSetChanged();
    }

    /**
     * Returns Picture Object {@link GalleryModel}
     *
     * @param position
     * @return
     */
    public GalleryModel getItem(final int position) {

        if (galleryPictureList == null || galleryPictureList.isEmpty()) {
            return null;
        }

        return galleryPictureList.get(position);
    }






    /**
     * @param parent
     * @param viewType
     * @return {@link GalleryViewHolder}
     */
    @Override
    public GalleryViewHolder onCreateDataViewHolder(ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        mItemListImageBinding = DataBindingUtil.inflate(layoutInflater,
                R.layout.item_list_image, parent, false);

        return new GalleryViewHolder(mItemListImageBinding, onItemClickListener);
    }

    /**
     * Binding properties to Layout
     *
     * @param holder
     * @param position
     */
    @Override
    public void onBindDataViewHolder(GalleryViewHolder holder, int position) {

        GalleryModel galleryModel = getItem(position);

        if (galleryModel == null) {
            return;
        }

        holder.bind(galleryModel);
    }

    /**
     * @return number of pictures
     */
    @Override
    public int getDataItemCount() {
        if (galleryPictureList == null || galleryPictureList.isEmpty()) {
            return 0;
        }

        return galleryPictureList.size();
    }

    @Override
    public int getDataItemViewType() {
        return 0;
    }

    /**
     * Removing data from list
     */
    public void clearData() {

        galleryPictureList.clear();
        notifyDataSetChanged();

    }

}