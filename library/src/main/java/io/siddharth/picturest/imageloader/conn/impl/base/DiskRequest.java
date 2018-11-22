package io.siddharth.picturest.imageloader.conn.impl.base;

/**
 * Local request
 */
public abstract class DiskRequest<D> extends FullCacheRequest<D, Void> {

    @Override
    public Void requestWeb() {
        return null;
    }

    @Override
    public void cacheInDisk(Void webCache) {

    }

}
