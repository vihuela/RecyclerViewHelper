package com.hadlink.rvhelpperlib.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * AdapterView adapter
 *
 * @param <M> bean
 * @author lyao inspiration from ：https://github.com/bingoogolapple/BGAAdapter-Android
 */
public abstract class AdapterViewAdapter<M> extends BaseAdapter {
    protected final int mItemLayoutId;
    protected Context mContext;
    protected List<M> mDatas;
    protected OnItemChildClickListener mOnItemChildClickListener;
    protected OnItemChildLongClickListener mOnItemChildLongClickListener;
    protected OnItemChildCheckedChangeListener mOnItemChildCheckedChangeListener;

    public AdapterViewAdapter(Context context, int itemLayoutId) {
        mContext = context;
        mItemLayoutId = itemLayoutId;
        mDatas = new ArrayList<>();
    }

    @Override
    public int getCount() {
        return mDatas.size();
    }

    @Override
    public M getItem(int position) {
        return mDatas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final AdapterViewHolder viewHolder = AdapterViewHolder.dequeueReusableAdapterViewHolder(convertView, parent, mItemLayoutId);
        viewHolder.getViewHolderHelper().setPosition(position);
        viewHolder.getViewHolderHelper().setOnItemChildClickListener(mOnItemChildClickListener);
        viewHolder.getViewHolderHelper().setOnItemChildLongClickListener(mOnItemChildLongClickListener);
        viewHolder.getViewHolderHelper().setOnItemChildCheckedChangeListener(mOnItemChildCheckedChangeListener);
        setItemChildListener(viewHolder.getViewHolderHelper());

        fillData(viewHolder.getViewHolderHelper(), position, getItem(position));
        return viewHolder.getConvertView();
    }

    /**
     * subItem click or longClick empty imp
     *
     * @param viewHolderHelper
     */
    protected void setItemChildListener(ViewHolderHelper viewHolderHelper) {
    }

    /**
     * fill datas
     *
     * @param viewHolderHelper
     * @param position
     * @param model
     */
    protected abstract void fillData(ViewHolderHelper viewHolderHelper, int position, M model);

    /**
     * subItem click lis(need adapter override setItemChildListener!!)
     *
     * @param onItemChildClickListener
     */
    public void setOnItemChildClickListener(OnItemChildClickListener onItemChildClickListener) {
        mOnItemChildClickListener = onItemChildClickListener;
    }

    /**
     * subItem longClick lis(need adapter override setItemChildListener!!)
     *
     * @param onItemChildLongClickListener
     */
    public void setOnItemChildLongClickListener(OnItemChildLongClickListener onItemChildLongClickListener) {
        mOnItemChildLongClickListener = onItemChildLongClickListener;
    }

    /**
     * subItem check lis(need adapter override setItemChildListener!!)
     *
     * @param onItemChildCheckedChangeListener
     */
    public void setOnItemChildCheckedChangeListener(OnItemChildCheckedChangeListener onItemChildCheckedChangeListener) {
        mOnItemChildCheckedChangeListener = onItemChildCheckedChangeListener;
    }

    /**
     * get Datas
     *
     * @return
     */
    public List<M> getDatas() {
        return mDatas;
    }

    /**
     * set new datas,set null,clear all(first get datas for server or pull to refresh)
     *
     * @param datas
     */
    public void setDatas(List<M> datas) {
        if (datas != null) {
            mDatas = datas;
        } else {
            mDatas.clear();
        }
        notifyDataSetChanged();
    }

    /**
     * insert data to datas header(example weibo refresh same newly data)
     *
     * @param datas
     */
    public void addNewDatas(List<M> datas) {
        if (datas != null) {
            mDatas.addAll(0, datas);
            notifyDataSetChanged();
        }
    }

    /**
     * insert data to datas footer(example weibo loadmore same newly data)
     *
     * @param datas
     */
    public void addMoreDatas(List<M> datas) {
        if (datas != null) {
            mDatas.addAll(mDatas.size(), datas);
            notifyDataSetChanged();
        }
    }

    /**
     * clear data
     */
    public void clear() {
        mDatas.clear();
        notifyDataSetChanged();
    }

    /**
     * remove data for position
     *
     * @param position
     */
    public void removeItem(int position) {
        mDatas.remove(position);
        notifyDataSetChanged();
    }

    /**
     * remove data for obj
     *
     * @param model
     */
    public void removeItem(M model) {
        mDatas.remove(model);
        notifyDataSetChanged();
    }

    /**
     * insert data for position
     *
     * @param position
     * @param model
     */
    public void addItem(int position, M model) {
        mDatas.add(position, model);
        notifyDataSetChanged();
    }

    /**
     * insert data to header
     *
     * @param model
     */
    public void addFirstItem(M model) {
        addItem(0, model);
    }

    /**
     * insert data to footer
     *
     * @param model
     */
    public void addLastItem(M model) {
        addItem(mDatas.size(), model);
    }

    /**
     * replace data for position
     *
     * @param location
     * @param newModel
     */
    public void setItem(int location, M newModel) {
        mDatas.set(location, newModel);
        notifyDataSetChanged();
    }

    /**
     * replace data for obj
     *
     * @param oldModel
     * @param newModel
     */
    public void setItem(M oldModel, M newModel) {
        setItem(mDatas.indexOf(oldModel), newModel);
    }

    /**
     * move item position
     *
     * @param fromPosition
     * @param toPosition
     */
    public void moveItem(int fromPosition, int toPosition) {
        Collections.swap(mDatas, fromPosition, toPosition);
        notifyDataSetChanged();
    }
}