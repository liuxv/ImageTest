package com.lx.test.mvp.presenter;

import com.bumptech.glide.Glide;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.load.resource.bitmap.CircleCrop;
import com.bumptech.glide.request.RequestOptions;
import com.lx.test.R;
import com.lx.test.common.mvp.BasePresenter;
import com.lx.test.mvp.model.ImageItemModel;
import com.lx.test.mvp.view.ImageItemView;

/**
 * @author liuxu@gotokeep.com (Liu Xu)
 */
public class GlidePresenter extends BasePresenter<ImageItemView, ImageItemModel> {

    public GlidePresenter(ImageItemView view) {
        super(view);
    }

    @Override
    public void bind(ImageItemModel model) {

        RequestOptions options = new RequestOptions().centerCrop()
            .placeholder(R.drawable.arrow)
            .error(R.drawable.no_net)
            .format(DecodeFormat.PREFER_RGB_565)
            .transform(new CircleCrop())
            .priority(Priority.HIGH);

        Glide.with(view.getContext()).load(model.getUrl()).apply(options).into(view.getItemImage());

        view.getItemText().setText(model.getDesc());
    }
}
