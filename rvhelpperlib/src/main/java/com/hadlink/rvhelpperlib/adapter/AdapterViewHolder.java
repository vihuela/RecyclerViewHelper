
package com.hadlink.rvhelpperlib.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * AdapterView item ViewHolder
 */
public class AdapterViewHolder {
    protected View mConvertView;
    protected ViewHolderHelper mViewHolderHelper;

    private AdapterViewHolder(ViewGroup parent, int layoutId) {
        mConvertView = LayoutInflater.from(parent.getContext()).inflate(layoutId, parent, false);
        mConvertView.setTag(this);
        mViewHolderHelper = new ViewHolderHelper(parent, mConvertView);
    }

    /**
     * get Reuse ViewHolder
     *
     * @param convertView
     * @param parent
     * @param layoutId
     * @return
     */
    public static AdapterViewHolder dequeueReusableAdapterViewHolder(View convertView, ViewGroup parent, int layoutId) {
        if (convertView == null) {
            return new AdapterViewHolder(parent, layoutId);
        }
        return (AdapterViewHolder) convertView.getTag();
    }

    public ViewHolderHelper getViewHolderHelper() {
        return mViewHolderHelper;
    }

    public View getConvertView() {
        return mConvertView;
    }

}