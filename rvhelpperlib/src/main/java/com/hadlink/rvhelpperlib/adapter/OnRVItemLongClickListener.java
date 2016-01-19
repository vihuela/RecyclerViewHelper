
package com.hadlink.rvhelpperlib.adapter;

import android.view.View;
import android.view.ViewGroup;

/**
 * for RecyclerView item
 */
public interface OnRVItemLongClickListener {
    boolean onRVItemLongClick(ViewGroup parent, View itemView, int position);
}