package com.lx.test.mvp.adapter;

import android.view.View;
import android.view.ViewGroup;

import com.lx.test.common.adapter.BaseRecycleAdapter;
import com.lx.test.common.mvp.BasePresenter;
import com.lx.test.common.mvp.BaseView;
import com.lx.test.mvp.model.ImageItemModel;
import com.lx.test.mvp.presenter.FrescoPresenter;
import com.lx.test.mvp.presenter.GlidePresenter;
import com.lx.test.mvp.presenter.ImageLoaderPresenter;
import com.lx.test.mvp.presenter.PicassoPresenter;
import com.lx.test.mvp.view.DraweeItemView;
import com.lx.test.mvp.view.ImageItemView;

/**
 * @author liuxu@gotokeep.com (Liu Xu)
 */
public class ImageAdapter extends BaseRecycleAdapter<ImageItemModel> {

    public enum EngineType {
        GLIDE, FRESCO, IMAGE_LOADER, PICASSO
    }

    private EngineType engineType;

    public ImageAdapter(EngineType type) {
        this.engineType = type;
    }

    @Override
    protected BaseView newView(ViewGroup parent, int type) {
        switch (engineType) {
            case FRESCO:
                return DraweeItemView.newInstance(parent);
            case GLIDE:
            case IMAGE_LOADER:
            case PICASSO:
                return ImageItemView.newInstance(parent);
            default:
                return ImageItemView.newInstance(parent);
        }
    }

    @Override
    protected BasePresenter newPresenter(View view, int type) {
        switch (engineType) {
            case FRESCO:
                return new FrescoPresenter((DraweeItemView) view);
            case GLIDE:
                return new GlidePresenter((ImageItemView) view);
            case IMAGE_LOADER:
                return new ImageLoaderPresenter((ImageItemView) view);
            case PICASSO:
                return new PicassoPresenter((ImageItemView) view);
            default:
                return new GlidePresenter((ImageItemView) view);
        }
    }
}
