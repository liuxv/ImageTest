package com.lx.test.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;

import com.lx.test.common.activity.BaseActivity;
import com.lx.test.common.fragment.BaseFragment;
import com.lx.test.fragment.ImageListFragment;
import com.lx.test.mvp.adapter.ImageAdapter;

/**
 * @author liuxu@gotokeep.com (Liu Xu)
 */
public class ImageListActivity extends BaseActivity {

    public static void launch(Context context, ImageAdapter.EngineType type) {
        Intent intent = new Intent(context, ImageListActivity.class);
        if (!(context instanceof Activity)) {
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        }
        intent.putExtra(ImageListFragment.KEY_ENGINE_TYPE, type.ordinal());
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        fragment =
            (BaseFragment) Fragment.instantiate(this, ImageListFragment.class.getName(), getIntent().getExtras());
        replaceFragment(fragment);
    }
}
