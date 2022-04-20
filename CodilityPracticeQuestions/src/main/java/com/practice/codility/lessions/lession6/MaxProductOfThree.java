package com.practice.codility.lessions.lession6;

import java.util.Arrays;

/**
 * A non-empty array A consisting of N integers is given. The product of triplet (P, Q, R) equates to A[P] * A[Q] * A[R] (0 ≤ P < Q < R < N).
 * <p>
 * For example, array A such that:
 * <p>
 * A[0] = -3
 * A[1] = 1
 * A[2] = 2
 * A[3] = -2
 * A[4] = 5
 * A[5] = 6
 * contains the following example triplets:
 * <p>
 * (0, 1, 2), product is −3 * 1 * 2 = −6
 * (1, 2, 4), product is 1 * 2 * 5 = 10
 * (2, 4, 5), product is 2 * 5 * 6 = 60
 * Your goal is to find the maximal product of any triplet.
 * <p>
 * Write a function:
 * <p>
 * class Solution { public int solution(int[] A); }
 * <p>
 * that, given a non-empty array A, returns the value of the maximal product of any triplet.
 * <p>
 * For example, given array A such that:
 * <p>
 * A[0] = -3
 * A[1] = 1
 * A[2] = 2
 * A[3] = -2
 * A[4] = 5
 * A[5] = 6
 * the function should return 60, as the product of triplet (2, 4, 5) is maximal.
 * <p>
 * Write an efficient algorithm for the following assumptions:
 * <p>
 * N is an integer within the range [3..100,000];
 * each element of array A is an integer within the range [−1,000..1,000].
 * Copyright 2009–2022 by Codility Limited. All Rights Reserved. Unauthorized copying, publication or disclosure prohibited.
 */
public class MaxProductOfThree {
    public static void main(String[] args) {
        final int[] A = { -3, 1, 2, -2, 5, 6 };
        System.out.println(solution(A));
    }

    private static int solution(int[] A) {
        // Main Idea
        // max1 = positive * positive * positive
        // max2 = negative * negative * positive
        // max = Math.max(max_1, max_1)
        // just need to sort the integer array

        // sort the array
        Arrays.sort(A);

        // max1 = 1st biggest * 2nd biggest * 3rd biggest
        int max1 = A[A.length - 1] * A[A.length - 2] * A[A.length - 3];

        // max2 = 1st smallest * 2nd smallest * 1st biggest
        int max2 = A[0] * A[1] * A[A.length - 1];

        // take the maximum
        return Math.max(max1, max2);
    }
}
