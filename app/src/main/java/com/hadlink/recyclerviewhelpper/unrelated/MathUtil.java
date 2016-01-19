/*
 * Copyright (c) 2013, SDJ and/or its affiliates. All rights reserved.
 * Use, Copy is subject to authorized license.
 */
package com.hadlink.recyclerviewhelpper.unrelated;

import java.math.BigDecimal;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MathUtil {

    /**
     * 检查整数
     *
     * @param num
     * @param type "0+":非负整数 "+":正整数 "-0":非正整数 "-":负整数 "":整数
     * @return
     */
    public static boolean checkNumber(String num, String type) {
        String eL = "";
        if (type.equals("0+"))
            eL = "^\\d+$";// 非负整数
        else if (type.equals("+"))
            eL = "^\\d*[1-9]\\d*$";// 正整数
        else if (type.equals("-0"))
            eL = "^((-\\d+)|(0+))$";// 非正整数
        else if (type.equals("-"))
            eL = "^-\\d*[1-9]\\d*$";// 负整数
        else
            eL = "^-?\\d+$";// 整数
        Pattern p = Pattern.compile(eL);
        Matcher m = p.matcher(num);
        boolean b = m.matches();
        return b;
    }

    /**
     * 将一个浮点型保留一定位数
     *
     * @param source 源
     * @param number 保留位数
     * @return
     */
    public static float floatTransfer(Float source, int number) {
        float result = 0f;
        Integer numberTmp = (int) Math.pow(10, number);
        result = (float) (Math.round(source * numberTmp)) / numberTmp;
        return result;
    }

    /**
     * 将一个double型保留一定位数
     *
     * @param source 源
     * @param number 保留位数
     * @return
     */
    public static double doubleTransfer(double source, int number) {
        double result = 0f;
        Integer numberTmp = (int) Math.pow(10, number);
        result = (double) (Math.round(source * numberTmp)) / numberTmp;
        return result;
    }

    public static float formatFloat(Float source) {
        return floatTransfer(source, 2);
    }

    public static double formatDouble(Double source) {
        return doubleTransfer(source, 2);

    }

    public static void main(String[] args) throws Exception {
        float a = 12.01f;
        float b = 12.007f;
        float e = 0.001f;

        System.out.println(a + b);
        addFloat(a, b);

        System.out.println(a - b);
        subFloat(a, b);

        System.out.println(a * b);
        multiFloat(a, b);

        System.out.println(addFloat(a, b, e));
        System.out.println(subFloat(a, b, e));

        double c = 12.01;
        double d = 0.005;
        System.out.println(addDouble(c, d));
    }

    public static float addFloat(float a, float b) {
        BigDecimal b1 = new BigDecimal(Float.toString(a));
        BigDecimal b2 = new BigDecimal(Float.toString(b));
        Float result = b1.add(b2).floatValue();
        return result;
    }

    public static float subFloat(float a, float b) {
        BigDecimal b1 = new BigDecimal(Float.toString(a));
        BigDecimal b2 = new BigDecimal(Float.toString(b));
        Float result = b1.subtract(b2).floatValue();
        return result;
    }

    public static float multiFloat(float a, float b) {
        BigDecimal b1 = new BigDecimal(Float.toString(a));
        BigDecimal b2 = new BigDecimal(Float.toString(b));
        Float result = b1.multiply(b2).floatValue();
        return result;
    }

    public static float divFloat(float a, float b) {
        BigDecimal b1 = new BigDecimal(Float.toString(a));
        BigDecimal b2 = new BigDecimal(Float.toString(b));
        Float result = b1.divide(b2).floatValue();
        return result;
    }

    public static float addFloat(float a, float b, float c) {

        BigDecimal b1 = new BigDecimal(Float.toString(a));
        BigDecimal b2 = new BigDecimal(Float.toString(b));
        BigDecimal b3 = new BigDecimal(Float.toString(c));
        Float result = b1.add(b2).add(b3).floatValue();
        return result;
    }

    public static float subFloat(float a, float b, float c) {
        BigDecimal b1 = new BigDecimal(Float.toString(a));
        BigDecimal b2 = new BigDecimal(Float.toString(b));
        BigDecimal b3 = new BigDecimal(Float.toString(c));
        Float result = b1.subtract(b2).subtract(b3).floatValue();
        return result;
    }

    public static double addDouble(double a, double b) {
        BigDecimal b1 = new BigDecimal(Double.toString(a));
        BigDecimal b2 = new BigDecimal(Double.toString(b));
        Double result = b1.add(b2).doubleValue();
        return result;
    }

    public static double subDouble(double a, double b) {
        BigDecimal b1 = new BigDecimal(Double.toString(a));
        BigDecimal b2 = new BigDecimal(Double.toString(b));
        Double result = b1.subtract(b2).doubleValue();
        return result;
    }

    public static double multiDouble(double a, double b) {
        BigDecimal b1 = new BigDecimal(Double.toString(a));
        BigDecimal b2 = new BigDecimal(Double.toString(b));
        Double result = b1.multiply(b2).doubleValue();
        return result;
    }

}
