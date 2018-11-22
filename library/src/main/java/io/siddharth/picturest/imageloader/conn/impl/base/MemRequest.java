package io.siddharth.picturest.imageloader.conn.impl.base;

/**
 * Memory request
 */
public abstract class MemRequest extends FullCacheRequest<Void, Void> {

    @Override
    public Void requestWeb() {
        return null;
    }

    @Override
    public Void requestDisk() {
        return null;
    }

    @Override
    public void cacheInDisk(Void webCache) {

    }

    @Override
    public void cacheInMem(Void diskCache) {

    }
}
