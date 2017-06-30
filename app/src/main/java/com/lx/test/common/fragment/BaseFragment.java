package com.lx.test.common.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.lang.reflect.Field;

/**
 * 所有 fragment 的基类，目前只做声明周期的规范，不做其他任何业务
 *
 * @author liuxu@gotokeep.com (Liu Xu)
 */
public abstract class BaseFragment extends Fragment {

    protected View contentView;
    protected boolean inflated;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        contentView = inflater.inflate(getLayoutResId(), container, false);
        return contentView;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if (contentView != null) {
            onInflated(contentView, savedInstanceState);
            inflated = true;
        }
    }

    public boolean onKeyDown(int keyCode, KeyEvent event) {
        return false;
    }

    /**
     * 当 fragment inflated 结束的时候调用
     */
    protected abstract void onInflated(View contentView, Bundle savedInstanceState);

    /**
     * @return 当前 fragment 的 layout id
     */
    protected abstract int getLayoutResId();

    /**
     * 给外部提供 fragment 的 root view。继承类可以直接使用 {@link BaseFragment#contentView}。
     * 这里需要注意的是，在 fragment onDetached 之后这个返回值可能为 null
     */
    public View getContentView() {
        return contentView;
    }

    protected <T extends View> T findViewById(int resId) {
        return (T) contentView.findViewById(resId);
    }

    @Override
    public void onDetach() {
        super.onDetach();
        try {
            // 避免 fragment detach 时候 child fragment 还在使用时候带来的坑
            Field childFragmentManager = Fragment.class.getDeclaredField("mChildFragmentManager");
            childFragmentManager.setAccessible(true);
            childFragmentManager.set(this, null);
        } catch (NoSuchFieldException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    public void onNewIntent(Intent intent) {

    }
}
