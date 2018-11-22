package io.siddharth.picturest.imageloader.cache.impl;

import io.siddharth.picturest.imageloader.cache.ICache;
import io.siddharth.picturest.imageloader.entity.ImageModel;

/**
 * Abstract image cache
 */
public abstract class AbsModelCache<I, O> implements ICache<I, O> {

    protected ImageModel model;

    public AbsModelCache(ImageModel model) {
        this.model = model;
    }

}
