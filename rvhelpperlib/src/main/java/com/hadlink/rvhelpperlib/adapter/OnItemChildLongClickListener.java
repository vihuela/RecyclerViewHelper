
package com.hadlink.rvhelpperlib.adapter;

import android.view.View;
import android.view.ViewGroup;

/**
 * AdapterView和RecyclerView的item中子控件长按事件监听器
 */
public interface OnItemChildLongClickListener {
    /**
     * 如果设置了多个条目，此回调，可能不会回调，因为元素可能不存在
     */
    boolean onItemChildLongClick(ViewGroup parent, View childView, int position);
}