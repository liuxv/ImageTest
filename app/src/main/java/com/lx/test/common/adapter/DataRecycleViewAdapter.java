package com.lx.test.common.adapter;

import android.support.v7.widget.RecyclerView;

import java.util.List;

/**
 * RecyclerView 的数据 adapter
 *
 * @author liuxu@gotokeep.com (Liu Xu)
 */
public abstract class DataRecycleViewAdapter<VH extends RecyclerView.ViewHolder, T> extends RecyclerView.Adapter<VH> {

    /**
     * 与 RecyclerView.Adapter 的 NO_POSITION 相等, 插入最后一个位置
     */
    public static final int LAST_POSITION = -1;

    protected List<T> dataList;

    /**
     * 按照 data adapter 的方式重写方法
     */
    public void add(T model, int position) {
        position = position == LAST_POSITION ? getItemCount() : position;
        dataList.add(position, model);
        notifyItemInserted(position);
        notifyItemPositionChange(position);
    }

    public void remove(int position) {
        if (position == LAST_POSITION && getItemCount() > 0) {
            position = getItemCount() - 1;
        }

        if (position > LAST_POSITION && position < getItemCount()) {
            dataList.remove(position);
            notifyItemRemoved(position);
            notifyItemPositionChange(position);
        }
    }

    public void setData(List<T> dataList) {
        if (dataList == null) {
            throw new IllegalArgumentException("modelData must not be null");
        }
        this.dataList = dataList;
        notifyDataSetChanged();
    }

    public List<T> getData() {
        return dataList;
    }

    public T getItem(int position) {
        if (position >= dataList.size()) {
            return null;
        }
        return dataList.get(position);
    }

    public void clear() {
        if (dataList != null) {
            dataList.clear();
        }
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return dataList == null ? 0 : dataList.size();
    }

    private void notifyItemPositionChange(int position) {
        for (int i = position; i < getItemCount(); i++) {
            notifyItemChanged(i);
        }
    }
}
