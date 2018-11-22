package io.siddharth.picturest.imageloader.conn.impl.base;

import io.siddharth.picturest.imageloader.cache.impl.DiskCache;
import io.siddharth.picturest.imageloader.cache.impl.MemoryCache;
import io.siddharth.picturest.imageloader.entity.ImageModel;

/**
 * Default implementation
 */
public abstract class FullCacheRequest<D, W> extends BaseRequest<D, W> {

    protected DiskCache diskCache;
    protected MemoryCache memoryCache;

    @Override
    public void setModel(ImageModel model) {
        super.setModel(model);
        diskCache = new DiskCache(model);
        memoryCache = new MemoryCache(model);
    }
}
