package com.example.lifecyclelog.base;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

public abstract class GenericRecyclerAdapter<T> extends RecyclerView.Adapter<GenericRecyclerAdapter.ViewHolder<T>>
{
    private static final String TAG = GenericRecyclerAdapter.class.getName();

    /**
     * Datas
     */
    protected List<T> mDatas;

    /**
     * Context
     */
    protected Activity mContext;

    /**
     * Listener to notify user when dataset changed.
     */
    private OnDataSetChangedListener mDataSetChangedListener;

    public GenericRecyclerAdapter(Activity context)
    {
        this.mContext = context;
        mDatas = new ArrayList<>();
    }

    @Override
    public int getItemCount() {
        return mDatas.size();
    }

    /**
     * Add data to end of the list and refresh adapter.
     * @param data
     */
    public void add(T data)
    {
        add(mDatas.size(), data);
    }

    /**
     * Add data to position and refresh adapter.
     * @param data
     * @param position
     */
    public void add(int position, T data)
    {
        mDatas.add(position, data);
        notifyItemInserted(position);

        if (mDataSetChangedListener != null) {
            mDataSetChangedListener.onDataSetChanged(mDatas.size());
        }
    }

    /**
     * Replace item by an other.
     * @param itemOld
     * @param itemNew
     */
    public boolean replace(T itemOld, T itemNew)
    {
        int pos = mDatas.indexOf(itemOld);

        if (pos == -1) {
            return false;
        }

        mDatas.remove(pos);
        mDatas.add(pos, itemNew);

        notifyItemChanged(pos);

        if (mDataSetChangedListener != null) {
            mDataSetChangedListener.onDataSetChanged(mDatas.size());
        }

        return true;
    }

    /**
     * Add list of data and refresh adapter.
     * @param data
     */
    public void addAll(List<T> data)
    {
        int from = mDatas.size() - 1;
        mDatas.addAll(data);

        notifyItemRangeInserted(from, data.size());

        if (mDataSetChangedListener != null) {
            mDataSetChangedListener.onDataSetChanged(mDatas.size());
        }
    }

    /**
     * Clear all datas and refresh adapter.
     */
    public void clear()
    {
        mDatas.clear();
        notifyDataSetChanged();

        if (mDataSetChangedListener != null) {
            mDataSetChangedListener.onDataSetChanged(mDatas.size());
        }
    }

    /**
     * Set data to list and refresh adapter.
     * @param data
     */
    public void set(List<T> data)
    {
        mDatas.clear();
        addAll(data);
    }

    /**
     * Set list.
     * @param data
     */
    public void setList(List<T> data)
    {
        mDatas = data;
        notifyDataSetChanged();
    }

    /**
     * Remove object in list.
     * @param data
     */
    public void remove(T data)
    {
        int pos = indexOf(data);
        if(pos > -1) {
            remove(pos);
        }
    }

    /**
     * Remove at index in list.
     * @param index
     */
    public void remove(int index)
    {
        mDatas.remove(index);
        notifyItemRemoved(index);

        if (mDataSetChangedListener != null) {
            mDataSetChangedListener.onDataSetChanged(mDatas.size());
        }
    }

    /**
     * Get data item.
     * @param position
     * @return item
     */
    public T get(int position)
    {
        return mDatas.get(position);
    }

    /**
     * Get all data.
     * @return item list
     */
    public List<T> get()
    {
        return mDatas;
    }

    /**
     * @return if found, first item position in list, -1 otherwise.
     */
    public int indexOf(T item)
    {
        for (int i = 0; i < mDatas.size(); i++) {
            T dataItem = mDatas.get(i);
            if (dataItem.equals(item)) {
                return i;
            }
        }

        return -1;
    }


    public static class ViewHolder<T> extends RecyclerView.ViewHolder {
        public GenericWidgetView<T> widgetView;

        public ViewHolder(View itemView)
        {
            super(itemView);
            this.widgetView = (GenericWidgetView<T>)itemView;
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        return new ViewHolder(getItemView(parent, viewType));
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int position)
    {
        // View customization
        manageView(get(position), viewHolder, position);
        manageClickListeners(get(position), viewHolder.widgetView, position);

        viewHolder.widgetView.bind(mDatas.get(position));
    }

    public android.app.Activity getContext() {
        return mContext;
    }

    public void setContext(Activity context) {
        this.mContext = context;
    }

    public OnDataSetChangedListener getDataSetChangedListener() {
        return mDataSetChangedListener;
    }

    public void setDataSetChangedListener(OnDataSetChangedListener dataSetChangedListener) {
        this.mDataSetChangedListener = dataSetChangedListener;
    }

    /**
     * Methods used for customization
     */

    public abstract GenericWidgetView<T> getItemView(ViewGroup parent, int viewType);

    public void manageView(T data, ViewHolder holder, final int position)
    {
        // Do nothing, let user override this method to customize view.
    }

    public void manageClickListeners(T data, View v, final int position)
    {
        // Do nothing, let user override this method to customize view.
    }

    /**
     * Listener : On data list changed, send event.
     */
    public interface OnDataSetChangedListener
    {
        public void onDataSetChanged(int count);
    }
}