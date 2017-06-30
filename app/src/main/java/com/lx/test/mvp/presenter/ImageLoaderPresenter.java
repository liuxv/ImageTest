package com.lx.test.mvp.presenter;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;

import com.bumptech.glide.Glide;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.Target;
import com.lx.test.R;
import com.lx.test.common.mvp.BasePresenter;
import com.lx.test.mvp.model.ImageItemModel;
import com.lx.test.mvp.view.ImageItemView;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;

/**
 * @author liuxu@gotokeep.com (Liu Xu)
 */
public class ImageLoaderPresenter extends BasePresenter<ImageItemView, ImageItemModel> {

    public ImageLoaderPresenter(ImageItemView view) {
        super(view);
    }

    @Override
    public void bind(ImageItemModel model) {

        DisplayImageOptions options = new DisplayImageOptions.Builder()//
            .showImageOnLoading(R.drawable.arrow)
            .showImageOnFail(R.drawable.no_net)
            .showImageForEmptyUri(R.drawable.no_net)
            .cacheInMemory(true)
            .cacheOnDisk(true)
            .bitmapConfig(Bitmap.Config.RGB_565)
            .build();

        ImageLoader.getInstance().displayImage(model.getUrl(), view.getItemImage(), options);

        view.getItemText().setText(model.getDesc());
    }
}
