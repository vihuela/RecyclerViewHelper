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

package com.hadlink.recyclerviewhelpper.unrelated;

import android.support.v7.widget.RecyclerView;

import com.hadlink.recyclerviewhelpper.R;
import com.hadlink.rvhelpperlib.adapter.RecyclerViewAdapter;
import com.hadlink.rvhelpperlib.adapter.ViewHolderHelper;

/**
 * @author Created by lyao on 2016/1/18.
 * @update
 * @description
 */
public class MultiAdapter extends RecyclerViewAdapter<Object> {
    public final static int TYPE_1 = 1;
    public final static int TYPE_2 = 2;

    public MultiAdapter(RecyclerView recyclerView) {
        super(recyclerView, R.layout.item2);
    }

    @Override protected int getItemViewResId(int viewType) {
        switch (viewType) {
            case TYPE_1:
                return R.layout.item1;
            case TYPE_2:
                return R.layout.item2;
        }
        return super.getItemViewResId(viewType);
    }

    @Override public int getItemViewType(int position) {

        return (getItem(position) instanceof String) ? TYPE_1 : TYPE_2;
    }

    @Override protected void fillData(ViewHolderHelper viewHolderHelper, int position, Object model) {
        switch (getItemViewType(position)) {
            case TYPE_1:
                String s = (String) model;
                viewHolderHelper.setText(R.id.tv, s);
                break;
            case TYPE_2:
                FuelBean fuelBean = (FuelBean) model;
                LabelView_New labelViewNew = viewHolderHelper.getView(R.id.labelView);
                labelViewNew.setText(fuelBean.discount + "折");
                viewHolderHelper.setText(R.id.faveVal, fuelBean.faceVal + "");
                viewHolderHelper.setText(R.id.price, fuelBean.price + "");
                viewHolderHelper.getView(R.id.mainContent).setSelected(fuelBean.isSelect);
                break;
        }

    }
    public void setSelectItem(int position) {
        Object item = getItem(position);
        if(item instanceof FuelBean){
            FuelBean fuelBean =(FuelBean)item;
            fuelBean.isSelect = !fuelBean.isSelect;
            notifyItemChanged(position);
        }
    }
}