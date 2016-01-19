
package com.hadlink.rvhelpperlib.adapter;

import android.view.View;
import android.view.ViewGroup;

/**
 * RecyclerView的item长按事件监听器
 */
public interface OnRVItemLongClickListener {
    boolean onRVItemLongClick(ViewGroup parent, View itemView, int position);
}