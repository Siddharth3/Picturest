package io.siddharth.picturest.imageloader.conn.impl.disk;

import android.graphics.Bitmap;

import java.io.File;

import io.siddharth.picturest.imageloader.conn.impl.base.DiskRequest;
import io.siddharth.picturest.imageloader.utils.ImageCompress;
import io.siddharth.picturest.imageloader.utils.Uri2Path;

/**
 * Content:// image loading
 */
public class MediaRequest extends DiskRequest<File> {

    @Override
    public Bitmap requestMem() {
        return memoryCache.getCache();
    }

    @Override
    public File requestDisk() {
        String path = Uri2Path.getImageAbsolutePath(model.getContext(), model.getUri());
        File file = new File(path);
        return file.exists() ? file : null;
    }

    @Override
    public void cacheInMem(File diskCache) {
        Bitmap bitmap = ImageCompress.getImage(diskCache, model.getViewHeight(), model.getViewWidth());
        memoryCache.setCache(bitmap);
    }
}
