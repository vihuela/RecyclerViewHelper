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

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Created by lyao on 2016/2/1.
 * @description
 */
public class DataEngine {
    public static List<String> S_MOCK1 = new ArrayList<>();
    public static List<String> S_MOCK2 = new ArrayList<>();
    public static List<Object> S_MOCK3 = new ArrayList<>();
    public static List<FuelBean> S_MOCK4 = new ArrayList<>();

    static {
        Collections.addAll(S_MOCK1,
                "item1item1item1item1item1item1item1item1item1item1item1item1item1item1item1item1item1item1item1item1item1item1item1item1item1item1item1item1item1item1item1item1item1item1item1item1item1item1item1item1item1item1item1item1item1item1item1item1item1",
                "item2",
                "item3",
                "item4",
                "WRAP-CONTENT");
        Collections.addAll(S_MOCK2,
                "RecyclerView",
                "RecyclerView",
                "RecyclerView",
                "Height",
                "WRAP-CONTENT");

        S_MOCK4.add(new FuelBean("1000", 96, "1000加油卡"));
        S_MOCK4.add(new FuelBean("100", 94, "100加油卡"));
        S_MOCK4.add(new FuelBean("10000", 98, "10000加油卡"));
        S_MOCK4.add(new FuelBean("500", 93, "500加油卡"));
        S_MOCK4.add(new FuelBean("500", 93, "500加油卡"));
        S_MOCK4.add(new FuelBean("500", 93, "500加油卡"));
        S_MOCK4.add(new FuelBean("500", 93, "500加油卡"));

        S_MOCK3.add(new FuelBean("1000", 96, "1000加油卡"));
        S_MOCK3.add("1000加油卡");
        S_MOCK3.add(new FuelBean("100", 94, "100加油卡"));
        S_MOCK3.add("100加油卡");
        S_MOCK3.add(new FuelBean("10000", 98, "10000加油卡"));
        S_MOCK3.add("10000加油卡");
        S_MOCK3.add(new FuelBean("500", 93, "500加油卡"));
        S_MOCK3.add("500加油卡");
        S_MOCK3.add(new FuelBean("500", 93, "500加油卡"));
        S_MOCK3.add("500加油卡");
        S_MOCK3.add(new FuelBean("500", 93, "500加油卡"));
        S_MOCK3.add("500加油卡");
        S_MOCK3.add(new FuelBean("500", 93, "500加油卡"));
        S_MOCK3.add("500加油卡");
        S_MOCK3.add(new FuelBean("500", 93, "500加油卡"));
        S_MOCK3.add("500加油卡");
        S_MOCK3.add(new FuelBean("500", 93, "500加油卡"));
        S_MOCK3.add("500加油卡");
        S_MOCK3.add(new FuelBean("500", 93, "500加油卡"));
        S_MOCK3.add("500加油卡");
        S_MOCK3.add(new FuelBean("500", 93, "500加油卡"));
        S_MOCK3.add("500加油卡");
        S_MOCK3.add(new FuelBean("500", 93, "500加油卡"));
        S_MOCK3.add("500加油卡");
        S_MOCK3.add(new FuelBean("500", 93, "500加油卡"));
        S_MOCK3.add("500加油卡");
        S_MOCK3.add(new FuelBean("500", 93, "500加油卡"));
        S_MOCK3.add("500加油卡");
        S_MOCK3.add(new FuelBean("500", 93, "500加油卡"));
        S_MOCK3.add("500加油卡");
        S_MOCK3.add(new FuelBean("500", 93, "500加油卡"));
        S_MOCK3.add("500加油卡");
        S_MOCK3.add(new FuelBean("500", 93, "500加油卡"));
        S_MOCK3.add("500加油卡");
        S_MOCK3.add(new FuelBean("500", 93, "500加油卡"));
        S_MOCK3.add("500加油卡");
        S_MOCK3.add(new FuelBean("500", 93, "500加油卡"));
        S_MOCK3.add("500加油卡");
        S_MOCK3.add(new FuelBean("500", 93, "500加油卡"));
        S_MOCK3.add("500加油卡");
        S_MOCK3.add(new FuelBean("500", 93, "500加油卡"));
        S_MOCK3.add("500加油卡");
        S_MOCK3.add(new FuelBean("500", 93, "500加油卡"));
        S_MOCK3.add("500加油卡");
        S_MOCK3.add(new FuelBean("500", 93, "500加油卡"));
        S_MOCK3.add("500加油卡");
        S_MOCK3.add(new FuelBean("500", 93, "500加油卡"));
        S_MOCK3.add("500加油卡");
        S_MOCK3.add(new FuelBean("500", 93, "500加油卡"));
        S_MOCK3.add("500加油卡");
        S_MOCK3.add(new FuelBean("500", 93, "500加油卡"));
        S_MOCK3.add("500加油卡");
        S_MOCK3.add(new FuelBean("500", 93, "500加油卡"));
        S_MOCK3.add("500加油卡");
    }
}
