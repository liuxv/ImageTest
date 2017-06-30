package com.lx.test.mvp.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.lx.test.R;
import com.lx.test.common.mvp.BaseView;
import com.lx.test.common.utils.ViewUtils;

/**
 * @author liuxu@gotokeep.com (Liu Xu)
 */
public class DraweeItemView extends RelativeLayout implements BaseView {

    private TextView itemText;
    private SimpleDraweeView itemImage;

    public DraweeItemView(Context context) {
        super(context);
    }

    public DraweeItemView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public static DraweeItemView newInstance(ViewGroup parent) {
        return (DraweeItemView) ViewUtils.newInstance(parent, R.layout.view_image_drawee_item);
    }

    public static DraweeItemView newInstance(Context context) {
        return (DraweeItemView) ViewUtils.newInstance(context, R.layout.view_image_drawee_item);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        initView();
    }

    private void initView() {
        itemText = (TextView) findViewById(R.id.item_text);
        itemImage = (SimpleDraweeView) findViewById(R.id.item_image);
    }

    public TextView getItemText() {
        return itemText;
    }

    public SimpleDraweeView getItemImage() {
        return itemImage;
    }

    @Override
    public View getView() {
        return this;
    }
}
