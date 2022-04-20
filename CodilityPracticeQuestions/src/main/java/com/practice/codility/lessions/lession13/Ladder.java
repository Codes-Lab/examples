package com.practice.codility.lessions.lession13;

import java.util.Arrays;

/**
 * You have to climb up a ladder. The ladder has exactly N rungs, numbered from 1 to N. With each step, you can ascend by one or two rungs. More precisely:
 * <p>
 * with your first step you can stand on rung 1 or 2,
 * if you are on rung K, you can move to rungs K + 1 or K + 2,
 * finally you have to stand on rung N.
 * Your task is to count the number of different ways of climbing to the top of the ladder.
 * <p>
 * For example, given N = 4, you have five different ways of climbing, ascending by:
 * <p>
 * 1, 1, 1 and 1 rung,
 * 1, 1 and 2 rungs,
 * 1, 2 and 1 rung,
 * 2, 1 and 1 rungs, and
 * 2 and 2 rungs.
 * Given N = 5, you have eight different ways of climbing, ascending by:
 * <p>
 * 1, 1, 1, 1 and 1 rung,
 * 1, 1, 1 and 2 rungs,
 * 1, 1, 2 and 1 rung,
 * 1, 2, 1 and 1 rung,
 * 1, 2 and 2 rungs,
 * 2, 1, 1 and 1 rungs,
 * 2, 1 and 2 rungs, and
 * 2, 2 and 1 rung.
 * The number of different ways can be very large, so it is sufficient to return the result modulo 2P, for a given integer P.
 * <p>
 * Write a function:
 * <p>
 * class Solution { public int[] solution(int[] A, int[] B); }
 * <p>
 * that, given two non-empty arrays A and B of L integers, returns an array consisting of L integers specifying the consecutive answers; position I should contain the number of different ways of climbing the ladder with A[I] rungs modulo 2B[I].
 * <p>
 * For example, given L = 5 and:
 * <p>
 * A[0] = 4   B[0] = 3
 * A[1] = 4   B[1] = 2
 * A[2] = 5   B[2] = 4
 * A[3] = 5   B[3] = 3
 * A[4] = 1   B[4] = 1
 * the function should return the sequence [5, 1, 8, 0, 1], as explained above.
 * <p>
 * Write an efficient algorithm for the following assumptions:
 * <p>
 * L is an integer within the range [1..50,000];
 * each element of array A is an integer within the range [1..L];
 * each element of array B is an integer within the range [1..30].
 * Copyright 2009–2022 by Codility Limited. All Rights Reserved. Unauthorized copying, publication or disclosure prohibited.
 */
public class Ladder {

    public static void main(String[] args) {
        final int[] A = { 4, 4, 5, 5, 1 };
        final int[] B = { 3, 2, 4, 3, 1 };
        System.out.println(Arrays.toString(new Ladder().solution(A, B)));
    }

    //when N = 4 then ways to climbing = 5
    //when N = 5 then ways to climbing = 8
    //4=5
    //5=8
    //6=13 which is a Fibonacci series(exluding first element 0) 1 1 2 3 5 8 13 21 ...
    //N= N + 1 of Fib.
    private int[] solution(int[] A, int[] B) {
        //Get Fibonacci series starting from 1.
        int[] fibs = new int[A.length + 1];
        fibs[0] = 1;
        fibs[1] = 1;
        for (int i = 2; i < A.length + 1; i++) {
            fibs[i] = (fibs[i - 2] + fibs[i - 1]);
        }

        //Result would be Fib series value for the given rungs module 2 power of given B value.
        int[] result = new int[A.length];
        for (int i = 0; i < A.length; i++) {
            int mod = (int) Math.pow(2, B[i]);
            result[i] = fibs[A[i]] % mod;
        }
        return result;
    }
}
