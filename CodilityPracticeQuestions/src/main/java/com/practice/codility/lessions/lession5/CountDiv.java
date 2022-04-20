package com.practice.codility.lessions.lession5;

/**
 * Write a function:
 * <p>
 * class Solution { public int solution(int A, int B, int K); }
 * <p>
 * that, given three integers A, B and K, returns the number of integers within the range [A..B] that are divisible by K, i.e.:
 * <p>
 * { i : A ≤ i ≤ B, i mod K = 0 }
 * <p>
 * For example, for A = 6, B = 11 and K = 2, your function should return 3, because there are three numbers divisible by 2 within the range [6..11], namely 6, 8 and 10.
 * <p>
 * Write an efficient algorithm for the following assumptions:
 * <p>
 * A and B are integers within the range [0..2,000,000,000];
 * K is an integer within the range [1..2,000,000,000];
 * A ≤ B.
 * Copyright 2009–2022 by Codility Limited. All Rights Reserved. Unauthorized copying, publication or disclosure prohibited.
 */
public class CountDiv {
    public static void main(String[] args) {
        System.out.println(solution(6, 11, 2));
    }

    private static int solution(int A, int B, int K) {
        int numberOfDivisibleIntegers = 0;
        for (int i = A; i <= B; i++) {
            if (i % K == 0) {
                numberOfDivisibleIntegers++;
            }
        }
        return numberOfDivisibleIntegers;
    }
}
