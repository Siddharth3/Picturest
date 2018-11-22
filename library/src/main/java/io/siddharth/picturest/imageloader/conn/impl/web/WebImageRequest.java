package io.siddharth.picturest.imageloader.conn.impl.web;

import android.graphics.Bitmap;

import java.io.File;
import java.io.InputStream;
import java.net.HttpURLConnection;

import io.siddharth.picturest.imageloader.conn.impl.base.FullCacheRequest;
import io.siddharth.picturest.imageloader.utils.ImageCompress;

/**
 * Network image request
 */
public class WebImageRequest extends FullCacheRequest<File, InputStream> {

    @Override
    public Bitmap requestMem() {
        return memoryCache.getCache();
    }

    @Override
    public File requestDisk() {
        return diskCache.getCache();
    }

    @Override
    public InputStream requestWeb() {

        try {
            HttpURLConnection conn = ConnController.getURLConnection(model.getPath());

            int responseCode = -1;
            if (conn != null) {
                responseCode = conn.getResponseCode();
            }
            if (responseCode == 200) {// Successful reception
                return conn.getInputStream();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public void cacheInDisk(InputStream webCache) {
        diskCache.setCache(webCache);
    }

    @Override
    public void cacheInMem(File diskCache) {
        Bitmap bitmap = ImageCompress.getImage(diskCache, model.getViewHeight(), model.getViewWidth());
        memoryCache.setCache(bitmap);
    }

}
