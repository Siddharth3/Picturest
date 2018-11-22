package io.siddharth.picturest.imageloader.conn.impl.mem;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import io.siddharth.picturest.imageloader.conn.impl.base.MemRequest;

/**
 * Resource request mipmap/drawable
 */
public class ResourceRequest extends MemRequest {

    @Override
    public Bitmap requestMem() {
        return BitmapFactory.decodeResource(model.getContext().getResources(), Integer.valueOf(model.getPath()));
    }

}
