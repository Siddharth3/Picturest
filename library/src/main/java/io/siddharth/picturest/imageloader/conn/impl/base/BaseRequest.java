package io.siddharth.picturest.imageloader.conn.impl.base;

import io.siddharth.picturest.imageloader.conn.ICacheRequest;
import io.siddharth.picturest.imageloader.entity.ImageModel;

/**
 * Default implementation
 */
public abstract class BaseRequest<D, W> implements ICacheRequest<D, W> {

    protected ImageModel model;

    @Override
    public void setModel(ImageModel model) {
        this.model = model;
    }

    @Override
    public String getRequestPath() {
        return model.getPath();
    }
}
