package com.practice.codility.lessions.lession6;

import java.util.Arrays;

/**
 * An array A consisting of N integers is given. A triplet (P, Q, R) is triangular if 0 ≤ P < Q < R < N and:
 * <p>
 * A[P] + A[Q] > A[R],
 * A[Q] + A[R] > A[P],
 * A[R] + A[P] > A[Q].
 * For example, consider array A such that:
 * <p>
 * A[0] = 10    A[1] = 2    A[2] = 5
 * A[3] = 1     A[4] = 8    A[5] = 20
 * Triplet (0, 2, 4) is triangular.
 * <p>
 * Write a function:
 * <p>
 * class Solution { public int solution(int[] A); }
 * <p>
 * that, given an array A consisting of N integers, returns 1 if there exists a triangular triplet for this array and returns 0 otherwise.
 * <p>
 * For example, given array A such that:
 * <p>
 * A[0] = 10    A[1] = 2    A[2] = 5
 * A[3] = 1     A[4] = 8    A[5] = 20
 * the function should return 1, as explained above. Given array A such that:
 * <p>
 * A[0] = 10    A[1] = 50    A[2] = 5
 * A[3] = 1
 * the function should return 0.
 * <p>
 * Write an efficient algorithm for the following assumptions:
 * <p>
 * N is an integer within the range [0..100,000];
 * each element of array A is an integer within the range [−2,147,483,648..2,147,483,647].
 * Copyright 2009–2022 by Codility Limited. All Rights Reserved. Unauthorized copying, publication or disclosure prohibited.
 */
public class Triangle {

    public static void main(String[] args) {
        final int[] A = { 10, 2, 5, 1, 8, 20 };
        System.out.println(solution(A));
    }

    private static int solution(int[] A) {
        //You don't have to check all three conditions here i.e.
        //
        //A[P] + A[Q] > A[R], A[Q] + A[R] > A[P], A[R] + A[P] > A[Q].
        //
        //If you have sorted the array than
        //
        //A[Q] + A[R] > A[P] &&
        //A[R] + A[P] > A[Q] are always true because 0 ≤ P < Q < R i.e. R is greater than P and Q.
        // So you should only check for
        // A[P] + A[Q] > A[R].

        int length = A.length;
        if (length < 3) {
            return 0;
        }
        Arrays.sort(A);
        for (int i = 0; i < length - 2; i++) {
            if (A[i] + A[i + 1] > A[i + 2]) {
                return 1;
            }
        }
        return 0;
    }

}
