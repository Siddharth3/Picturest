package io.siddharth.picturest.imageloader.conn.impl.disk;

import android.graphics.Bitmap;

import java.io.File;

import io.siddharth.picturest.imageloader.conn.impl.base.DiskRequest;
import io.siddharth.picturest.imageloader.utils.ImageCompress;

/**
 * Local image loading
 */
public class LocalRequest extends DiskRequest<File> {

    @Override
    public Bitmap requestMem() {
        return memoryCache.getCache();
    }

    @Override
    public File requestDisk() {
        File file = new File(model.getUri().getPath());
        return file.exists() ? file : null;
    }

    @Override
    public void cacheInMem(File diskCache) {
        Bitmap bitmap = ImageCompress.getImage(diskCache, model.getViewHeight(), model.getViewWidth());
        memoryCache.setCache(bitmap);
    }
}
