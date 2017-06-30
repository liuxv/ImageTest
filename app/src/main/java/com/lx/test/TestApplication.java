package com.lx.test;

import android.app.Application;
import android.content.Context;
import android.graphics.Bitmap;

import com.facebook.cache.disk.DiskCacheConfig;
import com.facebook.common.util.ByteConstants;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.imagepipeline.core.ImagePipelineConfig;
import com.lx.test.common.image.loader.SmartImageDecoder;
import com.nostra13.universalimageloader.cache.disc.DiskCache;
import com.nostra13.universalimageloader.cache.disc.impl.UnlimitedDiskCache;
import com.nostra13.universalimageloader.cache.disc.impl.ext.LruDiskCache;
import com.nostra13.universalimageloader.cache.disc.naming.HashCodeFileNameGenerator;
import com.nostra13.universalimageloader.cache.memory.impl.LRULimitedMemoryCache;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.utils.StorageUtils;

import java.io.File;
import java.io.IOException;

/**
 * @author liuxu@gotokeep.com (Liu Xu)
 */
public class TestApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        //小图片的磁盘配置,用来储存用户头像之类的小图
        DiskCacheConfig diskSmallCacheConfig =
            DiskCacheConfig.newBuilder(this).setBaseDirectoryPath(this.getCacheDir())//缓存图片基路径
                .setBaseDirectoryName(getString(R.string.app_name))//文件夹名
                .setMaxCacheSize(20 * ByteConstants.MB)//默认缓存的最大大小。
                .setMaxCacheSizeOnLowDiskSpace(10 * ByteConstants.MB)//缓存的最大大小,使用设备时低磁盘空间。
                .setMaxCacheSizeOnVeryLowDiskSpace(5 * ByteConstants.MB)//缓存的最大大小,当设备极低磁盘空间
                .build();

        ImagePipelineConfig imagePipelineConfig = ImagePipelineConfig.newBuilder(this)
            .setDownsampleEnabled(true)
            .setResizeAndRotateEnabledForNetwork(true)
            .setSmallImageDiskCacheConfig(diskSmallCacheConfig)
            .setBitmapsConfig(Bitmap.Config.RGB_565)
            .build();

        Fresco.initialize(this, imagePipelineConfig);


        ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(this)//
            .threadPoolSize(3)//
            .threadPriority(Thread.NORM_PRIORITY - 2)//
            //.denyCacheImageMultipleSizesInMemory()//
            .memoryCache(new LRULimitedMemoryCache(1024 * 1024))//
            .diskCache(getDefaultDiskCache(this)).imageDecoder(new SmartImageDecoder()).build();

        ImageLoader.getInstance().init(config);
    }

    /**
     * try create lru disk cache, use unlimited cache if fail
     *
     * @param context context
     * @return defaultDiskCache
     */
    private DiskCache getDefaultDiskCache(Context context) {
        DiskCache defaultDiskCache;
        File cacheDir = StorageUtils.getOwnCacheDirectory(context, "keep/cache");

        try {
            defaultDiskCache = new LruDiskCache(cacheDir, new HashCodeFileNameGenerator(), 50 * 1024 * 1024);
        } catch (IOException e) {
            defaultDiskCache = new UnlimitedDiskCache(cacheDir);
        }

        return defaultDiskCache;
    }
}
