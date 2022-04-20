package com.practice.codility.lessions.lession4;

import java.util.stream.IntStream;

/**
 * A non-empty array A consisting of N integers is given.
 * <p>
 * A permutation is a sequence containing each element from 1 to N once, and only once.
 * <p>
 * For example, array A such that:
 * <p>
 * A[0] = 4
 * A[1] = 1
 * A[2] = 3
 * A[3] = 2
 * is a permutation, but array A such that:
 * <p>
 * A[0] = 4
 * A[1] = 1
 * A[2] = 3
 * is not a permutation, because value 2 is missing.
 * <p>
 * The goal is to check whether array A is a permutation.
 * <p>
 * Write a function:
 * <p>
 * class Solution { public int solution(int[] A); }
 * <p>
 * that, given an array A, returns 1 if array A is a permutation and 0 if it is not.
 * <p>
 * For example, given array A such that:
 * <p>
 * A[0] = 4
 * A[1] = 1
 * A[2] = 3
 * A[3] = 2
 * the function should return 1.
 * <p>
 * Given array A such that:
 * <p>
 * A[0] = 4
 * A[1] = 1
 * A[2] = 3
 * the function should return 0.
 * <p>
 * Write an efficient algorithm for the following assumptions:
 * <p>
 * N is an integer within the range [1..100,000];
 * each element of array A is an integer within the range [1..1,000,000,000].
 * Copyright 2009–2022 by Codility Limited. All Rights Reserved. Unauthorized copying, publication or disclosure prohibited.
 */
public class PermCheck {

    public static void main(String[] args) {
        final int[] A = { 4, 1, 3, 2 };
        System.out.println(solution(A));
    }

    private static int solution(int[] A) {
        //Since array is expected to be consecutive sequence numbers 1 to N.
        int maxNumber = A.length;
        int sumOfAllConsecutiveNumbers = (maxNumber * (maxNumber + 1)) / 2;
        int actualSum = IntStream
            .of(A)
            .sum();
        if (sumOfAllConsecutiveNumbers == actualSum) {
            return 1;
        } else {
            return 0;
        }
    }

}
