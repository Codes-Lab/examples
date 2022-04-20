package com.practice.codility.lessions.lession9;

/**
 *
 */
public class MaxSliceSum {
    public static void main(String[] args) {
        final int[] A = { 3, 2, -6, 4, 0 };
        System.out.println(solution(A));
    }

    private static int solution(int[] A) {
        long maxSum = Integer.MIN_VALUE;
        long sum = Integer.MIN_VALUE;

        for (int a : A) {
            sum = Math.max(sum + a, a);
            maxSum = Math.max(sum, maxSum);
        }
        return (int) maxSum;
    }
}
