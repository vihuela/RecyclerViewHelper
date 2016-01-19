package com.hadlink.recyclerviewhelpper.unrelated;

import java.math.BigDecimal;

public class FuelBean {
    public float faceVal;
    public float price;
    public int discount;
    public boolean isSelect;
    public String des;//描述

    public FuelBean(String faceVal, int discount, String des) {
        this.faceVal = MathUtil.floatTransfer(new BigDecimal(faceVal).floatValue(), 2);
        this.discount = discount;
        this.price = MathUtil.floatTransfer(this.faceVal * discount / 100, 2);
        this.des = des;
    }
}
