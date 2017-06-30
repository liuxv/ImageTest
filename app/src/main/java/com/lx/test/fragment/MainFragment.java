package com.lx.test.fragment;

import android.os.Bundle;
import android.view.View;

import com.lx.test.R;
import com.lx.test.activity.ImageListActivity;
import com.lx.test.common.fragment.BaseFragment;
import com.lx.test.mvp.adapter.ImageAdapter;

/**
 * @author liuxu@gotokeep.com (Liu Xu)
 */
public class MainFragment extends BaseFragment {

    @Override
    protected void onInflated(View contentView, Bundle savedInstanceState) {

        findViewById(R.id.text1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ImageListActivity.launch(v.getContext(), ImageAdapter.EngineType.GLIDE);
            }
        });

        findViewById(R.id.text2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ImageListActivity.launch(v.getContext() , ImageAdapter.EngineType.FRESCO);
            }
        });

        findViewById(R.id.text3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ImageListActivity.launch(v.getContext() , ImageAdapter.EngineType.IMAGE_LOADER);
            }
        });

        findViewById(R.id.text4).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ImageListActivity.launch(v.getContext() , ImageAdapter.EngineType.PICASSO);
            }
        });
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.fragment_main;
    }
}
