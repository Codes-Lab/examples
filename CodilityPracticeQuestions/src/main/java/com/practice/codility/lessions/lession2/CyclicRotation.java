package com.practice.codility.lessions.lession2;

import java.util.Arrays;

/**
 * An array A consisting of N integers is given. Rotation of the array means that each element is shifted right by one index, and the last element of the array is moved to the first place. For example, the rotation of array A = [3, 8, 9, 7, 6] is [6, 3, 8, 9, 7] (elements are shifted right by one index and 6 is moved to the first place).
 * <p>
 * The goal is to rotate array A K times; that is, each element of A will be shifted to the right K times.
 * <p>
 * Write a function:
 * <p>
 * class Solution { public int[] solution(int[] A, int K); }
 * <p>
 * that, given an array A consisting of N integers and an integer K, returns the array A rotated K times.
 * <p>
 * For example, given
 * <p>
 * A = [3, 8, 9, 7, 6]
 * K = 3
 * the function should return [9, 7, 6, 3, 8]. Three rotations were made:
 * <p>
 * [3, 8, 9, 7, 6] -> [6, 3, 8, 9, 7]
 * [6, 3, 8, 9, 7] -> [7, 6, 3, 8, 9]
 * [7, 6, 3, 8, 9] -> [9, 7, 6, 3, 8]
 * For another example, given
 * <p>
 * A = [0, 0, 0]
 * K = 1
 * the function should return [0, 0, 0]
 * <p>
 * Given
 * <p>
 * A = [1, 2, 3, 4]
 * K = 4
 * the function should return [1, 2, 3, 4]
 * <p>
 * Assume that:
 * <p>
 * N and K are integers within the range [0..100];
 * each element of array A is an integer within the range [−1,000..1,000].
 * In your solution, focus on correctness. The performance of your solution will not be the focus of the assessment.
 * <p>
 * Copyright 2009–2022 by Codility Limited. All Rights Reserved. Unauthorized copying, publication or disclosure prohibited.
 */
public class CyclicRotation {

    public static void main(String[] args) {
        int[] A = { 3, 8, 9, 7, 6 };
        final int[] shiftedArr = solution(A, 5);
        System.out.println(Arrays.toString(shiftedArr));
    }

    private static int[] solution(int[] A, int K) {
        //If Array is empty or having a single element or to be shifted by same as array length
        // then shifting is non-necessary since it would result the same as input
        if (A.length == 0 || A.length == 1 || A.length == K) {
            return A;
        }
        while (K > 0) {
            //Shift the array by 1, K times.
            shiftByOne(A);
            K--;
        }
        return A;
    }

    private static int[] shiftByOne(int[] A) {
        final int length = A.length;
        int lastEle = A[length - 1];
        //System.arraycopy(A, 0, A, 1, length - 1); also works for following loop.
        for (int i = length - 1; i > 0; i--) {
            A[i] = A[i - 1];
        }
        A[0] = lastEle;
        return A;
    }

}
