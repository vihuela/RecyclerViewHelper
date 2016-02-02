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

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.hadlink.recyclerviewhelpper.aty.GridViewAty;
import com.hadlink.recyclerviewhelpper.aty.ListViewAty;
import com.hadlink.recyclerviewhelpper.aty.RecyclerViewAty;
import com.hadlink.recyclerviewhelpper.aty.RecyclerViewMulAty;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }


    public void rv_single(View v) {
        startActivity(new Intent(this, RecyclerViewAty.class));
    }

    public void rv_multi(View v) {
        startActivity(new Intent(this, RecyclerViewMulAty.class));
    }

    public void lv(View v) {
        startActivity(new Intent(this, ListViewAty.class));
    }

    public void gv(View v) {
        startActivity(new Intent(this, GridViewAty.class));
    }


}
