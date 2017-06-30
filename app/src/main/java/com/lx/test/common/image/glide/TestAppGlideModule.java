package com.lx.test.common.image.glide;

import android.content.Context;

import com.bumptech.glide.GlideBuilder;
import com.bumptech.glide.annotation.GlideModule;
import com.bumptech.glide.module.AppGlideModule;

/**
 * @author liuxu@gotokeep.com (Liu Xu)
 */
@GlideModule
public class TestAppGlideModule extends AppGlideModule {

    @Override
    public void applyOptions(Context context, GlideBuilder builder) {
        super.applyOptions(context, builder);

        //builder.setMemoryCache(new LruResourceCache(1));
        //builder.setDiskCache(new ExternalCacheDiskCacheFactory(context, "lx", DiskCache.Factory.DEFAULT_DISK_CACHE_SIZE));
    }
}
