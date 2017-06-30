package com.lx.test.mvp.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.lx.test.R;
import com.lx.test.common.mvp.BaseView;
import com.lx.test.common.utils.ViewUtils;

/**
 * @author liuxu@gotokeep.com (Liu Xu)
 */
public class ImageItemView extends RelativeLayout implements BaseView {

    private TextView itemText;
    private ImageView itemImage;

    public ImageItemView(Context context) {
        super(context);
    }

    public ImageItemView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public static ImageItemView newInstance(ViewGroup parent) {
        return (ImageItemView) ViewUtils.newInstance(parent, R.layout.view_image_item);
    }

    public static ImageItemView newInstance(Context context) {
        return (ImageItemView) ViewUtils.newInstance(context, R.layout.view_image_item);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        initView();
    }

    private void initView() {
        itemText = (TextView) findViewById(R.id.item_text);
        itemImage = (ImageView) findViewById(R.id.item_image);
    }

    public TextView getItemText() {
        return itemText;
    }

    public ImageView getItemImage() {
        return itemImage;
    }

    @Override
    public View getView() {
        return this;
    }
}
