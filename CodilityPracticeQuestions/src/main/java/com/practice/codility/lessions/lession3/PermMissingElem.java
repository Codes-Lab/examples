package com.practice.codility.lessions.lession3;

import java.util.stream.IntStream;

/**
 * An array A consisting of N different integers is given. The array contains integers in the range [1..(N + 1)], which means that exactly one element is missing.
 * <p>
 * Your goal is to find that missing element.
 * <p>
 * Write a function:
 * <p>
 * class Solution { public int solution(int[] A); }
 * <p>
 * that, given an array A, returns the value of the missing element.
 * <p>
 * For example, given array A such that:
 * <p>
 * A[0] = 2
 * A[1] = 3
 * A[2] = 1
 * A[3] = 5
 * the function should return 4, as it is the missing element.
 * <p>
 * Write an efficient algorithm for the following assumptions:
 * <p>
 * N is an integer within the range [0..100,000];
 * the elements of A are all distinct;
 * each element of array A is an integer within the range [1..(N + 1)].
 * Copyright 2009–2022 by Codility Limited. All Rights Reserved. Unauthorized copying, publication or disclosure prohibited.
 */
public class PermMissingElem {
    public static void main(String[] args) {
        final int[] A = { 2, 3, 1, 5 };
        System.out.println(solution(A));
    }

    private static int solution(int[] A) {
        //This problem has a mathematical solution, based on the fact that the
        //sum of consecutive integers from 1 to n is equal to n(n+1)/2
        //https://en.wikipedia.org/wiki/1_%2B_2_%2B_3_%2B_4_%2B_%E2%8B%AF
        int maximumNumber = A.length + 1;
        int yieldSum = (maximumNumber * (maximumNumber + 1)) / 2;
        final int actualSum = IntStream
            .of(A)
            .sum();
        return yieldSum - actualSum;
    }
}
