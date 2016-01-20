/*
 *
 *   Copyright (c) 2016, lyao. lomoliger@hotmail.com
 *
 *   Part of the code from the open source community,
 *   thanks stackOverflow & gitHub .
 *   Licensed under the Apache License, Version 2.0 (the "License");
 *   you may not use this file except in compliance with the License.
 *   You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *   Unless required by applicable law or agreed to in writing, software
 *   distributed under the License is distributed on an "AS IS" BASIS,
 *   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *   See the License for the specific language governing permissions and
 *   limitations under the License.
 *
 */

package com.hadlink.rvhelpperlib.adapter;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * RecyclerView adapter
 *
 * <p>item click(longClick)，extend this class，external invoke setOnRVItemClickListener();<br>
 * subItem click(longCLick)，extend this class，override setItemChildListener,external invoke setOnItemChildClickListener();</p>
 *
 * @param <M> data type
 * @author lyao inspiration from ：https://github.com/bingoogolapple/BGAAdapter-Android
 */
public abstract class RecyclerViewAdapter<M> extends RecyclerView.Adapter<RecyclerViewHolder> {
    protected final int mItemLayoutId;
    protected Context mContext;
    protected List<M> mDatas;
    protected OnItemChildClickListener mOnItemChildClickListener;
    protected OnItemChildLongClickListener mOnItemChildLongClickListener;
    protected OnItemChildCheckedChangeListener mOnItemChildCheckedChangeListener;
    protected OnRVItemClickListener mOnRVItemClickListener;
    protected OnRVItemLongClickListener mOnRVItemLongClickListener;

    protected RecyclerView mRecyclerView;

    public RecyclerViewAdapter(RecyclerView recyclerView, int itemLayoutId) {
        mRecyclerView = recyclerView;
        mContext = mRecyclerView.getContext();
        mItemLayoutId = itemLayoutId;
        mDatas = new ArrayList<>();
    }

    public RecyclerViewAdapter(RecyclerView recyclerView, int itemLayoutId, List<M> list) {
        mRecyclerView = recyclerView;
        mContext = mRecyclerView.getContext();
        mItemLayoutId = itemLayoutId;
        mDatas = list;
    }

    @Override
    public int getItemCount() {
        return mDatas.size();
    }


    @Override
    public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View multiItem = inflateView(getItemViewResId(viewType), parent);
        View singleItem = inflateView(mItemLayoutId, parent);

        View itemView = multiItem != null ? multiItem : singleItem;
        RecyclerViewHolder viewHolder = new RecyclerViewHolder(mRecyclerView, itemView, mOnRVItemClickListener, mOnRVItemLongClickListener);
        viewHolder.getViewHolderHelper().setOnItemChildClickListener(mOnItemChildClickListener);
        viewHolder.getViewHolderHelper().setOnItemChildLongClickListener(mOnItemChildLongClickListener);
        viewHolder.getViewHolderHelper().setOnItemChildCheckedChangeListener(mOnItemChildCheckedChangeListener);
        setItemChildListener(viewHolder.getViewHolderHelper());
        return viewHolder;
    }

    private View inflateView(@LayoutRes int res, ViewGroup parent) {
        return res == View.NO_ID ? null : LayoutInflater.from(mContext).inflate(res, parent, false);
    }

    /**
     * by getItemViewType()set mul item
     *
     * @param viewType
     * @return
     */
    protected int getItemViewResId(int viewType) {
        return View.NO_ID;
    }

    /**
     * subItem click or longClick empty imp
     *
     * @param viewHolderHelper
     */
    protected void setItemChildListener(ViewHolderHelper viewHolderHelper) {
    }

    @Override
    public void onBindViewHolder(RecyclerViewHolder viewHolder, int position) {
        fillData(viewHolder.getViewHolderHelper(), position, getItem(position));
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
     * item click lis
     *
     * @param onRVItemClickListener
     */
    public void setOnRVItemClickListener(OnRVItemClickListener onRVItemClickListener) {
        mOnRVItemClickListener = onRVItemClickListener;
    }

    /**
     * item longClick lis
     *
     * @param onRVItemLongClickListener
     */
    public void setOnRVItemLongClickListener(OnRVItemLongClickListener onRVItemLongClickListener) {
        mOnRVItemLongClickListener = onRVItemLongClickListener;
    }

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

    public M getItem(int position) {
        return mDatas.get(position);
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
     * @param datas
     */
    public void addNewDatas(List<M> datas) {
        if (datas != null) {
            mDatas.addAll(0, datas);
            notifyItemRangeInserted(0, datas.size());
        }
    }

    /**
     * insert data to datas footer(example weibo loadmore same newly data)
     * @param datas
     */
    public void addMoreDatas(List<M> datas) {
        if (datas != null) {
            mDatas.addAll(mDatas.size(), datas);
            notifyItemRangeInserted(mDatas.size(), datas.size());
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
        notifyItemRemoved(position);
    }

    /**
     * remove data for obj
     *
     * @param model
     */
    public void removeItem(M model) {
        removeItem(mDatas.indexOf(model));
    }

    /**
     * insert data for position
     *
     * @param position
     * @param model
     */
    public void addItem(int position, M model) {
        mDatas.add(position, model);
        notifyItemInserted(position);
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
        notifyItemChanged(location);
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
        mDatas.add(toPosition, mDatas.remove(fromPosition));
        notifyItemMoved(fromPosition, toPosition);
    }
}