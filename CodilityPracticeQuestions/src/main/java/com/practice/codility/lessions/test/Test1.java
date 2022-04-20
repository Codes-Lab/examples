////////////////////////////////////////////////////////////////////////////////
//
// Created by AMundewal on 19.04.2022.
//
// Copyright (c) 2006 - 2022 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////

package com.practice.codility.lessions.test;

/**
 *
 */
public class Test1 {

    public static void main(String[] args) {
        final String s1 = "111";
        final String s2 = "1111010101111";
       /* StringBuilder s = new StringBuilder("1");
        for (int i = 1; i < 400000; i++) {
            s.append("1");
        }*/
        System.out.println(new Test1().solution(s1));
    }

    private int solution(String s) {
        int intValue = Integer.parseInt(s, 2);
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

}
