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

package com.hadlink.recyclerviewhelpper.aty;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import com.hadlink.recyclerviewhelpper.R;
import com.hadlink.recyclerviewhelpper.unrelated.DataEngine;
import com.hadlink.recyclerviewhelpper.unrelated.FuelBean;
import com.hadlink.recyclerviewhelpper.unrelated.LabelView_New;
import com.hadlink.rvhelpperlib.adapter.AdapterViewAdapter;
import com.hadlink.rvhelpperlib.adapter.OnItemChildClickListener;
import com.hadlink.rvhelpperlib.adapter.ViewHolderHelper;

import java.util.List;

/**
 * @author Created by lyao on 2016/2/1.
 * @description
 */
public class GridViewAty extends AppCompatActivity {
    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gv);

        GridView gv = (GridView) findViewById(R.id.gv);
        final GridViewAdp adapter = new GridViewAdp(this, R.layout.item2, DataEngine.S_MOCK4);
        adapter.setOnItemChildClickListener(new OnItemChildClickListener() {
            @Override public void onItemChildClick(ViewGroup parent, View childView, int position) {
                if (childView.getId() == R.id.mainContent) {
                    adapter.setSelectItem(position);
                }
            }
        });
        gv.setAdapter(adapter);
    }

    private class GridViewAdp extends AdapterViewAdapter<FuelBean> {

        public GridViewAdp(Context context, int itemLayoutId, List<FuelBean> list) {
            super(context, itemLayoutId, list);
        }

        @Override protected void setItemChildListener(ViewHolderHelper viewHolderHelper) {
            super.setItemChildListener(viewHolderHelper);
            viewHolderHelper.setItemChildClickListener(R.id.mainContent);
        }

        @Override protected void fillData(ViewHolderHelper viewHolderHelper, int position, FuelBean model) {
            LabelView_New labelViewNew = viewHolderHelper.getView(R.id.labelView);
            labelViewNew.setText(model.discount + "折");
            viewHolderHelper.setText(R.id.faveVal, model.faceVal + "");
            viewHolderHelper.setText(R.id.price, model.price + "");
            viewHolderHelper.getView(R.id.mainContent).setSelected(model.isSelect);
        }

        public void setSelectItem(int position) {
            List<FuelBean> datas = getDatas();
            FuelBean fuelBean = datas.get(position);
            if (!fuelBean.isSelect) {
                for (FuelBean f : datas) {
                    f.isSelect = false;
                }
                fuelBean.isSelect = true;
                notifyDataSetChanged();
            }
        }
    }
}
