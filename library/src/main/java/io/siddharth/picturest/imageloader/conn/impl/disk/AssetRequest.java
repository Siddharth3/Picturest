package io.siddharth.picturest.imageloader.conn.impl.disk;

import android.graphics.Bitmap;

import java.io.IOException;
import java.io.InputStream;

import io.siddharth.picturest.imageloader.conn.impl.base.DiskRequest;
import io.siddharth.picturest.imageloader.engine.PathParser;
import io.siddharth.picturest.imageloader.utils.ImageCompress;

/**
 * Image loading of assets directory
 */
public class AssetRequest extends DiskRequest<InputStream> {

    @Override
    public Bitmap requestMem() {
        return memoryCache.getCache();
    }

    @Override
    public InputStream requestDisk() {
        InputStream inputStream = null;
        try {
            inputStream = model.getContext().getResources().getAssets().open(model.getPath().replace(PathParser.PREFIX_ASSERT ,""));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return inputStream;
    }

    @Override
    public void cacheInMem(InputStream diskCache) {
        Bitmap bitmap = ImageCompress.getImage(diskCache, model.getViewHeight(), model.getViewWidth());
        memoryCache.setCache(bitmap);
    }
}
