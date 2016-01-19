package com.hadlink.rvhelpperlib.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * item click logic is here
 * subItem click logic is ViewHolderHelper
 */
public class RecyclerViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener, View.OnLongClickListener {

    protected Context mContext;
    protected OnRVItemClickListener mOnRVItemClickListener;
    protected OnRVItemLongClickListener mOnRVItemLongClickListener;
    protected ViewHolderHelper mViewHolderHelper;
    protected RecyclerView mRecyclerView;

    public RecyclerViewHolder(RecyclerView recyclerView, View itemView, OnRVItemClickListener onRVItemClickListener, OnRVItemLongClickListener onRVItemLongClickListener) {
        super(itemView);
        mRecyclerView = recyclerView;
        mContext = mRecyclerView.getContext();
        mOnRVItemClickListener = onRVItemClickListener;
        mOnRVItemLongClickListener = onRVItemLongClickListener;
        itemView.setOnClickListener(this);
        itemView.setOnLongClickListener(this);
        mViewHolderHelper = new ViewHolderHelper(mRecyclerView, this.itemView);
        mViewHolderHelper.setRecyclerViewHolder(this);
    }

    public ViewHolderHelper getViewHolderHelper() {
        return mViewHolderHelper;
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == this.itemView.getId() && null != mOnRVItemClickListener) {
            mOnRVItemClickListener.onRVItemClick(mRecyclerView, v, getAdapterPosition());
        }
    }

    @Override
    public boolean onLongClick(View v) {
        if (v.getId() == this.itemView.getId() && null != mOnRVItemLongClickListener) {
            return mOnRVItemLongClickListener.onRVItemLongClick(mRecyclerView, v, getAdapterPosition());
        }
        return false;
    }

}