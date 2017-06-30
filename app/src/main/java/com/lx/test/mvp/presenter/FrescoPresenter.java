package com.lx.test.mvp.presenter;

import android.graphics.drawable.Animatable;
import android.net.Uri;
import android.support.annotation.Nullable;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.controller.BaseControllerListener;
import com.facebook.drawee.controller.ControllerListener;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.imagepipeline.image.ImageInfo;
import com.lx.test.common.mvp.BasePresenter;
import com.lx.test.mvp.model.ImageItemModel;
import com.lx.test.mvp.view.DraweeItemView;

/**
 * @author liuxu@gotokeep.com (Liu Xu)
 */
public class FrescoPresenter extends BasePresenter<DraweeItemView, ImageItemModel> {

    public FrescoPresenter(DraweeItemView view) {
        super(view);
    }

    @Override
    public void bind(ImageItemModel model) {
        Uri uri = Uri.parse(model.getUrl());

        ControllerListener controllerListener = new BaseControllerListener<ImageInfo>() {
            @Override
            public void onFinalImageSet(
                String id,
                @Nullable ImageInfo imageInfo,
                @Nullable Animatable anim) {
                if (anim != null) {
                    // 其他控制逻辑
                    anim.start();
                }
            }
        };

        DraweeController controller = Fresco.newDraweeControllerBuilder()
            .setUri(uri)
            .setControllerListener(controllerListener)
            // 其他设置（如果有的话）
            .build();


        view.getItemImage().setController(controller);

        view.getItemText().setText(model.getDesc());
    }
}
