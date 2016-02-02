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

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.hadlink.recyclerviewhelpper.R;
import com.hadlink.recyclerviewhelpper.unrelated.DataEngine;
import com.hadlink.recyclerviewhelpper.unrelated.FuelAdapter;
import com.hadlink.recyclerviewhelpper.unrelated.FuelBean;
import com.hadlink.rvhelpperlib.adapter.OnItemChildClickListener;
import com.hadlink.rvhelpperlib.adapter.OnRVItemClickListener;
import com.hadlink.rvhelpperlib.adapter.RecyclerViewAdapter;
import com.hadlink.rvhelpperlib.adapter.ViewHolderHelper;
import com.hadlink.rvhelpperlib.decoration.GridItemDecoration;
import com.hadlink.rvhelpperlib.manager.WRGridLayoutManager;
import com.hadlink.rvhelpperlib.manager.WRLinearLayoutManager;
import com.hadlink.rvhelpperlib.utils.DensityUtils;

/**
 * @author Created by lyao on 2016/2/1.
 * @description
 */
public class RecyclerViewAty extends AppCompatActivity {
    private RecyclerView rv;

    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rv);
        rv = (RecyclerView) findViewById(R.id.rv);

        demo2();
    }

    private void demo2() {
        rv.setLayoutManager(new WRGridLayoutManager(this, 2));
        final FuelAdapter fuelAdapter = new FuelAdapter(rv, DataEngine.S_MOCK4);
        /**
         * item点击
         */
        fuelAdapter.setOnRVItemClickListener(new OnRVItemClickListener() {
            @Override public void onRVItemClick(ViewGroup parent, View itemView, int position) {
                fuelAdapter.setSelectItem(position, null);
            }
        });
        /**
         * item子条目点击
         */
        fuelAdapter.setOnItemChildClickListener(new OnItemChildClickListener() {
            @Override public void onItemChildClick(ViewGroup parent, View childView, int position) {
                FuelBean item = fuelAdapter.getItem(position);
                switch (childView.getId()) {
                    case R.id.faveVal:
                        Toast.makeText(parent.getContext(), item.faceVal + "", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.priceLayout:
                        Toast.makeText(parent.getContext(), item.price + "", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.labelView:
                        Toast.makeText(parent.getContext(), item.discount + "", Toast.LENGTH_SHORT).show();
                        break;
                }
            }
        });
        rv.addItemDecoration(new GridItemDecoration(2, DensityUtils.dip2px(this, 14f), true));
        rv.setAdapter(fuelAdapter);
    }

    private void demo1() {
        rv.setLayoutManager(new WRLinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        rv.setAdapter(new RecyclerViewAdapter<String>(rv, R.layout.item1, DataEngine.S_MOCK2) {

            @Override protected void fillData(ViewHolderHelper viewHolderHelper, int position, String model) {
                viewHolderHelper.setText(R.id.tv, model);
            }
        });
    }
}
