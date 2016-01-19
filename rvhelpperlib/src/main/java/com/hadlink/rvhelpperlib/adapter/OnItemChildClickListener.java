
package com.hadlink.rvhelpperlib.adapter;

import android.view.View;
import android.view.ViewGroup;

/**
 * AdapterView和RecyclerView的item中子控件点击事件监听器
 */
public interface OnItemChildClickListener {
    /**
     * 如果设置了多个条目，此回调，可能不会回调，因为元素可能不存在
     */
    void onItemChildClick(ViewGroup parent, View childView, int position);
}