
package com.hadlink.rvhelpperlib.adapter;

import android.view.View;
import android.view.ViewGroup;

/**
 * RecyclerView的item点击事件监听器
 */
public interface OnRVItemClickListener {
    void onRVItemClick(ViewGroup parent, View itemView, int position);
}