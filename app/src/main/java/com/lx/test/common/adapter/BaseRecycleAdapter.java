package com.lx.test.common.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.lx.test.common.mvp.BasePresenter;
import com.lx.test.common.mvp.BaseView;

/**
 * @author liuxu@gotokeep.com (Liu Xu)
 */
public abstract class BaseRecycleAdapter<M> extends DataRecycleViewAdapter<BaseRecycleAdapter.BaseViewHolder, M> {

    @Override
    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        BasePresenter presenter;
        BaseView baseView;
        baseView = newView(parent, viewType);
        presenter = newPresenter(baseView.getView(), viewType);
        return new BaseViewHolder(baseView.getView(), presenter);
    }

    @Override
    public void onBindViewHolder(BaseViewHolder viewHolder, int position) {
        if (viewHolder.presenter == null) {
            return;
        }
        doBind(viewHolder.presenter, getItem(position));
    }

    public final static class BaseViewHolder extends RecyclerView.ViewHolder {
        public final BasePresenter presenter;

        public BaseViewHolder(View itemView, BasePresenter presenter) {
            super(itemView);
            this.presenter = presenter;
        }
    }

    /**
     * 数据驱动 view present
     */
    protected void doBind(BasePresenter presenter, M baseModel) {
        // 由于 presenter 是重用的，所以先执行解绑，再绑定
        presenter.unbind();
        // 绑定数据
        presenter.bind(baseModel);
    }

    /**
     * 新建一个数据 Item 的 View
     *
     * @param parent 父容器对象
     * @param type 需要新建的 ViewType, 根据此值返回对应的 TypeView
     */
    protected abstract BaseView newView(ViewGroup parent, int type);

    /**
     * 新建一个 Presenter 处理器,与 ItemView 相呼应
     *
     * @param view newView 构建出,或者缓存的 ItemView 对象
     * @param type 该数据 ItemView 对象对应的 Type
     */
    protected abstract BasePresenter newPresenter(View view, int type);
}
