package io.siddharth.picturest.imageloader.conn;

import android.graphics.Bitmap;

import io.siddharth.picturest.imageloader.entity.ImageModel;

/**
 * Cache request interface
 *
 * @param <D> Local cache type
 * @param <W> Network data type
 */
public interface ICacheRequest<D, W> {

    /**
     * Setting up the data model
     */
    void setModel(ImageModel model);

    /**
     * Get the request address for printing the log
     */
    String getRequestPath();

    /**
     * Request memory
     */
    Bitmap requestMem();

    /**
     * Request local
     */
    D requestDisk();

    /**
     * Request network
     */
    W requestWeb();

    /**
     * Cache to memory
     */
    void cacheInMem(D diskCache);

    /**
     * Cache to local
     */
    void cacheInDisk(W webCache);

}
