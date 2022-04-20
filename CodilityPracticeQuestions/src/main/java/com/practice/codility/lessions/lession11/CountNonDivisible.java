package com.practice.codility.lessions.lession11;

import java.util.Arrays;

/**
 * You are given an array A consisting of N integers.
 * <p>
 * For each number A[i] such that 0 ≤ i < N, we want to count the number of elements of the array that are not the divisors of A[i]. We say that these elements are non-divisors.
 * <p>
 * For example, consider integer N = 5 and array A such that:
 * <p>
 * A[0] = 3
 * A[1] = 1
 * A[2] = 2
 * A[3] = 3
 * A[4] = 6
 * For the following elements:
 * <p>
 * A[0] = 3, the non-divisors are: 2, 6,
 * A[1] = 1, the non-divisors are: 3, 2, 3, 6,
 * A[2] = 2, the non-divisors are: 3, 3, 6,
 * A[3] = 3, the non-divisors are: 2, 6,
 * A[4] = 6, there aren't any non-divisors.
 * Write a function:
 * <p>
 * class Solution { public int[] solution(int[] A); }
 * <p>
 * that, given an array A consisting of N integers, returns a sequence of integers representing the amount of non-divisors.
 * <p>
 * Result array should be returned as an array of integers.
 * <p>
 * For example, given:
 * <p>
 * A[0] = 3
 * A[1] = 1
 * A[2] = 2
 * A[3] = 3
 * A[4] = 6
 * the function should return [2, 4, 3, 2, 0], as explained above.
 * <p>
 * Write an efficient algorithm for the following assumptions:
 * <p>
 * N is an integer within the range [1..50,000];
 * each element of array A is an integer within the range [1..2 * N].
 * Copyright 2009–2022 by Codility Limited. All Rights Reserved. Unauthorized copying, publication or disclosure prohibited.
 */
public class CountNonDivisible {
    public static void main(String[] args) {
        final int[] A = { 3, 1, 2, 3, 6 };
        System.out.println(Arrays.toString(solution(A)));
    }

    private static int[] solution(int[] A) {
        final int[] nonDivisors = new int[A.length];
        for (int i = 0; i < A.length; i++) {
            int countOfNonDivisor = 0;
            int element = A[i];
            for (int j = 0; j < A.length; j++) {
                if (i == j) {
                    continue;
                }
                if (element % A[j] != 0) {
                    countOfNonDivisor++;
                }
            }
            nonDivisors[i] = countOfNonDivisor;
        }
        return nonDivisors;
    }
}
