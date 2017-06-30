package com.lx.test.common.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;

import com.lx.test.R;
import com.lx.test.common.fragment.BaseFragment;

/**
 * 基础的 activity，内部除了做 fragment 的初始化，剩下不做任何业务（当然底层肯定还会记录日志），保证所有 activity 继承时候的纯净。
 *
 * @author liuxu@gotokeep.com (Liu Xu)
 */
public class BaseActivity extends AppCompatActivity {

    protected BaseFragment fragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        if (fragment != null) {
            fragment.onNewIntent(intent);
        }
    }

    protected void replaceFragment(Fragment newFragment) {
        replaceFragment(newFragment, null, false);
    }

    protected void replaceFragment(Fragment newFragment, Bundle arguments, boolean isAddStack) {
        if (isFinishing()) {
            return;
        }
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        if (arguments != null) {
            newFragment.setArguments(arguments);
        }
        transaction.replace(R.id.ui_framework__fragment_container, newFragment);
        if (isAddStack) {
            transaction.addToBackStack(null);
        }
        transaction.commitAllowingStateLoss();
    }

    /**
     * 获得 layout id
     */
    protected int getLayoutId() {
        return R.layout.activity_base;
    }

    /**
     * 获得当前的 fragment 主要用于在 fragment 里面接受 onActivityResult
     */
    public BaseFragment getFragment() {
        return fragment;
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (fragment != null) {
            if (fragment.onKeyDown(keyCode, event)) {
                return true;
            }
        }
        return super.onKeyDown(keyCode, event);
    }
}
