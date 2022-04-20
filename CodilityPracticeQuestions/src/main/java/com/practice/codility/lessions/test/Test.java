////////////////////////////////////////////////////////////////////////////////
//
// Created by AMundewal on 18.04.2022.
//
// Copyright (c) 2006 - 2022 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////

package com.practice.codility.lessions.test;

/**
 *
 */
public class Test {

    public static void main(String[] args) {
        final String s1 = "111";
        final String s2 = "1111010101111";
        StringBuilder s = new StringBuilder("1");
        for (int i = 1; i < 400000; i++) {
            s.append("1");
        }
        //System.out.println(new Test().solution(s.toString()));
        System.out.println(new Test().solution(s1));
    }

    private int solution(String s) {
        double intValue = convertBinaryStringToDouble(s);
        if (((Double) intValue).isInfinite()) {
            return 799999;
        }
        int steps = 0;
        if (intValue <= 0) {
            return steps;
        }
        while (intValue > 0) {
            steps++;
            if (intValue % 2 == 0) {
                intValue /= 2;
            } else {
                intValue -= 1;
            }
        }
        return steps;
    }

    public static double convertBinaryStringToDouble(String str) {
        double j = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '1') {
                j = j + Math.pow(2, str.length() - 1 - i);
            }
        }
        return j;
    }
}
