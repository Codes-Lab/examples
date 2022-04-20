package com.practice.codility.lessions.lession10;

/**
 * An integer N is given, representing the area of some rectangle.
 * <p>
 * The area of a rectangle whose sides are of length A and B is A * B, and the perimeter is 2 * (A + B).
 * <p>
 * The goal is to find the minimal perimeter of any rectangle whose area equals N. The sides of this rectangle should be only integers.
 * <p>
 * For example, given integer N = 30, rectangles of area 30 are:
 * <p>
 * (1, 30), with a perimeter of 62,
 * (2, 15), with a perimeter of 34,
 * (3, 10), with a perimeter of 26,
 * (5, 6), with a perimeter of 22.
 * Write a function:
 * <p>
 * class Solution { public int solution(int N); }
 * <p>
 * that, given an integer N, returns the minimal perimeter of any rectangle whose area is exactly equal to N.
 * <p>
 * For example, given an integer N = 30, the function should return 22, as explained above.
 * <p>
 * Write an efficient algorithm for the following assumptions:
 * <p>
 * N is an integer within the range [1..1,000,000,000].
 * Copyright 2009–2022 by Codility Limited. All Rights Reserved. Unauthorized copying, publication or disclosure prohibited.
 */
public class MinPerimeterRectangle {
    public static void main(String[] args) {
        final int N = 30;
        System.out.println(solution(N));
    }

    private static int solution(int N) {
        int minPerimeter = Integer.MAX_VALUE;
        for (int sideA = 1; sideA <= N; sideA++) {
            if (N % sideA != 0) {
                continue;
            }
            int sideB = N / sideA; //As per (N = (A * B))
            minPerimeter = Math.min(minPerimeter, (2 * (sideA + sideB)));
        }
        return minPerimeter;
    }
}
