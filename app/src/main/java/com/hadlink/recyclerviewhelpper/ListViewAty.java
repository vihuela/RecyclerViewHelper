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
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;

import com.hadlink.recyclerviewhelpper.unrelated.DataEngine;
import com.hadlink.rvhelpperlib.adapter.AdapterViewAdapter;
import com.hadlink.rvhelpperlib.adapter.OnItemChildClickListener;
import com.hadlink.rvhelpperlib.adapter.ViewHolderHelper;

/**
 * @author Created by lyao on 2016/2/1.
 * @description
 */
public class ListViewAty extends AppCompatActivity {
    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lv);

        ListView lv = (ListView) findViewById(R.id.lv);
        final AdapterViewAdapter<String> adapter = new AdapterViewAdapter<String>(this, R.layout.item1, DataEngine.S_MOCK1) {

            @Override protected void fillData(ViewHolderHelper viewHolderHelper, int position, String model) {
                viewHolderHelper.setText(R.id.tv, model);
            }

            @Override protected void setItemChildListener(ViewHolderHelper viewHolderHelper) {
                viewHolderHelper.setItemChildClickListener(R.id.rootView);
            }
        };
        adapter.setOnItemChildClickListener(new OnItemChildClickListener() {
            @Override public void onItemChildClick(ViewGroup parent, View childView, int position) {
                if (childView.getId() == R.id.rootView)
                    Toast.makeText(parent.getContext(), adapter.getItem(position), Toast.LENGTH_SHORT).show();
            }
        });
        lv.setAdapter(adapter);
    }
}
