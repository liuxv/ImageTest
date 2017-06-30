package com.lx.test.fragment;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SimpleItemAnimator;
import android.view.View;

import com.lx.test.R;
import com.lx.test.common.fragment.BaseFragment;
import com.lx.test.mvp.adapter.ImageAdapter;
import com.lx.test.mvp.model.ImageItemModel;
import com.lx.test.utils.DataUtils;

import java.util.ArrayList;

/**
 * @author liuxu@gotokeep.com (Liu Xu)
 */
public class ImageListFragment extends BaseFragment {

    public static final String KEY_ENGINE_TYPE = "engine_type";

    private RecyclerView recyclerView;
    private ImageAdapter adapter;

    @Override
    protected void onInflated(View contentView, Bundle savedInstanceState) {
        recyclerView = findViewById(R.id.recycler_view);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        adapter = new ImageAdapter(ImageAdapter.EngineType.values()[getArguments().getInt(KEY_ENGINE_TYPE)]);
        adapter.setData(DataUtils.addWarImageModel(new ArrayList<ImageItemModel>()));
        recyclerView.setAdapter(adapter);
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.fragment_image_list;
    }
}
