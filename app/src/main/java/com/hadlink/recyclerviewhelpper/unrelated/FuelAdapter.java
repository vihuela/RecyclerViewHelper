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

import java.util.List;

/**
 * @author Created by lyao on 2016/1/18.
 * @update
 * @description
 */
public class FuelAdapter extends RecyclerViewAdapter<FuelBean> {
    public FuelAdapter(RecyclerView recyclerView, List<FuelBean> list) {
        super(recyclerView, R.layout.item2, list);
    }

    @Override protected void fillData(ViewHolderHelper viewHolderHelper, int position, FuelBean model) {
        LabelView_New labelViewNew = viewHolderHelper.getView(R.id.labelView);
        labelViewNew.setText(model.discount + "折");
        viewHolderHelper.setText(R.id.faveVal, model.faceVal + "");
        viewHolderHelper.setText(R.id.price, model.price + "");
        viewHolderHelper.getView(R.id.mainContent).setSelected(model.isSelect);
    }

    public void setSelectItem(int position, Runnable r) {
        List<FuelBean> datas = getDatas();
        FuelBean fuelBean = datas.get(position);
        if (!fuelBean.isSelect) {
            for (FuelBean f : datas) {
                f.isSelect = false;
            }
            fuelBean.isSelect = true;
            notifyDataSetChanged();
            if (r != null) r.run();
        }
    }
}