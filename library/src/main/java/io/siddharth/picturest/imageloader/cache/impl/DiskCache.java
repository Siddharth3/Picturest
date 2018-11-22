package io.siddharth.picturest.imageloader.cache.impl;

import android.content.Context;

import java.io.File;
import java.io.InputStream;

import io.siddharth.picturest.imageloader.entity.ImageModel;
import io.siddharth.picturest.imageloader.utils.IOUtils;
import io.siddharth.picturest.imageloader.utils.MD5Utils;

/**
 * Local cache
 */
public class DiskCache extends AbsModelCache<InputStream, File> {

    public DiskCache(ImageModel model) {
        super(model);
    }

    @Override
    public void setCache(InputStream content) {
        IOUtils.writeStreamToFile(content, IOUtils.getDiskCacheFile(model.getMd5Code(), model.getContext()));
    }

    @Override
    public File getCache() {
        File cacheFile = IOUtils.getDiskCacheFile(model.getMd5Code(), model.getContext());

        if (cacheFile.exists()) {// Local cache exists
            return cacheFile;
        } else {
            return null;
        }

    }

    /**
     * Clear the specified local cache
     */
    public static boolean clearCache(Context context,String key) {
        File cacheFile = IOUtils.getDiskCacheFile(MD5Utils.getMD5String(key), context);
        return cacheFile.exists() && cacheFile.delete();
    }

    /**
     * Clear all memory
     */
    public static boolean clearAllCache(Context context) {
        return IOUtils.removeDir(new File(IOUtils.getLocalCachePath(context)));
    }

}
