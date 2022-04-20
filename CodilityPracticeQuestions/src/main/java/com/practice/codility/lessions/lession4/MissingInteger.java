package com.practice.codility.lessions.lession4;

import java.util.Arrays;

/**
 * Write a function:
 * <p>
 * class Solution { public int solution(int[] A); }
 * <p>
 * that, given an array A of N integers, returns the smallest positive integer (greater than 0) that does not occur in A.
 * <p>
 * For example, given A = [1, 3, 6, 4, 1, 2], the function should return 5.
 * <p>
 * Given A = [1, 2, 3], the function should return 4.
 * <p>
 * Given A = [−1, −3], the function should return 1.
 * <p>
 * Write an efficient algorithm for the following assumptions:
 * <p>
 * N is an integer within the range [1..100,000];
 * each element of array A is an integer within the range [−1,000,000..1,000,000].
 * Copyright 2009–2022 by Codility Limited. All Rights Reserved. Unauthorized copying, publication or disclosure prohibited.
 */
public class MissingInteger {
    public static void main(String[] args) {
        final int[] A = { 1, 3, 6, 4, 1, 2 };
        System.out.println(solution(A));
    }

    private static int solution(int[] A) {
        int smallestPositiveInt = 1;
        Arrays.sort(A);
        for (int i = 0; i < A.length; i++) {
            final int positiveInt = smallestPositiveInt;
            if (Arrays
                .stream(A)
                .anyMatch(value -> value == positiveInt)) {
                smallestPositiveInt++;
            }
        }
        return smallestPositiveInt;
    }
}
