
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