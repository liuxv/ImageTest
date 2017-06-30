package com.lx.test.mvp.presenter;

import com.lx.test.R;
import com.lx.test.common.mvp.BasePresenter;
import com.lx.test.mvp.model.ImageItemModel;
import com.lx.test.mvp.view.ImageItemView;
import com.squareup.picasso.Picasso;

/**
 * @author liuxu@gotokeep.com (Liu Xu)
 */
public class PicassoPresenter extends BasePresenter<ImageItemView, ImageItemModel> {

    public PicassoPresenter(ImageItemView view) {
        super(view);
    }

    @Override
    public void bind(final ImageItemModel model) {

        Picasso.with(view.getContext())
            .load(model.getUrl())
            .placeholder(R.drawable.arrow)
            .error(R.drawable.no_net)
            .into(view.getItemImage());

        view.getItemText().setText(model.getDesc());
    }
}
