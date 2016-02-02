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

package com.hadlink.recyclerviewhelpper;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.hadlink.recyclerviewhelpper.unrelated.DataEngine;
import com.hadlink.recyclerviewhelpper.unrelated.MultiAdapter;
import com.hadlink.rvhelpperlib.adapter.OnRVItemClickListener;

/**
 * @author Created by lyao on 2016/2/1.
 * @description
 */
public class RecyclerViewMulAty extends AppCompatActivity {
    private RecyclerView rv;

    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rv);
        rv = (RecyclerView) findViewById(R.id.rv);

        demo2();
    }

    private void demo2() {

        rv.setLayoutManager(new LinearLayoutManager(this));
        final MultiAdapter multiAdapter = new MultiAdapter(rv);
        multiAdapter.setOnRVItemClickListener(new OnRVItemClickListener() {
            @Override public void onRVItemClick(ViewGroup parent, View itemView, int position) {
                int itemViewType = multiAdapter.getItemViewType(position);
                Object item = multiAdapter.getItem(position);
                switch (itemViewType) {
                    case MultiAdapter.TYPE_1:
                        Toast.makeText(parent.getContext(), (String) item, Toast.LENGTH_SHORT).show();

                        break;
                    case MultiAdapter.TYPE_2:
//                        Toast.makeText(parent.getContext(), ((FuelBean) item).price + "", Toast.LENGTH_SHORT).show();
                        multiAdapter.setSelectItem(position);
                        break;
                }
            }
        });
        rv.setAdapter(multiAdapter);
        multiAdapter.setDatas(DataEngine.S_MOCK3);
    }

}
