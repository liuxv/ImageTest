package com.lx.test.common.utils;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * 此类维护一些 View 的工具方法
 *
 * @author liuxu@gotokeep.com (Liu Xu)
 */
public class ViewUtils {


    private ViewUtils() {}

    /**
     * 设置 view 大小
     */
    public static void setViewSize(View view, int width, int height) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        layoutParams.width = width;
        layoutParams.height = height;
        view.setLayoutParams(layoutParams);
    }

    /**
     * 设置 view 的背景
     */
    public static void setBackground(View view, Drawable background) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            view.setBackground(background);
        } else {
            view.setBackgroundDrawable(background);
        }
    }

    /**
     * 创建一个 view
     */
    public static View newInstance(ViewGroup parent, int resId) {
        return LayoutInflater.from(parent.getContext()).inflate(resId, parent, false);
    }

    /**
     * 创建一个 view
     */
    public static View newInstance(Context context, int resId) {
        return LayoutInflater.from(context).inflate(resId, null);
    }

    /**
     * 清除 view 选择状态
     */
    public static void clearSelected(ViewGroup viewGroup, View withoutView) {
        if (viewGroup == null) {
            return;
        }
        for (int i = 0; i < viewGroup.getChildCount(); i++) {
            View child = viewGroup.getChildAt(i);
            if (child != withoutView) {
                child.setSelected(false);
            }
        }
    }
}
