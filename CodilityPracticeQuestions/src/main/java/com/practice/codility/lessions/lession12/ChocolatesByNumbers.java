package com.practice.codility.lessions.lession12;

/**
 * Two positive integers N and M are given. Integer N represents the number of chocolates arranged in a circle, numbered from 0 to N − 1.
 * <p>
 * You start to eat the chocolates. After eating a chocolate you leave only a wrapper.
 * <p>
 * You begin with eating chocolate number 0. Then you omit the next M − 1 chocolates or wrappers on the circle, and eat the following one.
 * <p>
 * More precisely, if you ate chocolate number X, then you will next eat the chocolate with number (X + M) modulo N (remainder of division).
 * <p>
 * You stop eating when you encounter an empty wrapper.
 * <p>
 * For example, given integers N = 10 and M = 4. You will eat the following chocolates: 0, 4, 8, 2, 6.
 * <p>
 * The goal is to count the number of chocolates that you will eat, following the above rules.
 * <p>
 * Write a function:
 * <p>
 * class Solution { public int solution(int N, int M); }
 * <p>
 * that, given two positive integers N and M, returns the number of chocolates that you will eat.
 * <p>
 * For example, given integers N = 10 and M = 4. the function should return 5, as explained above.
 * <p>
 * Write an efficient algorithm for the following assumptions:
 * <p>
 * N and M are integers within the range [1..1,000,000,000].
 * Copyright 2009–2022 by Codility Limited. All Rights Reserved. Unauthorized copying, publication or disclosure prohibited.
 */
public class ChocolatesByNumbers {

    public static void main(String[] args) {
        final int N = 10;
        final int M = 4;
        System.out.println(solution(N, M));
    }

    private static int solution(int N, int M) {
        // these already have a known answer
        if (M == 1) {
            return N;
        }
        if (M == N) {
            return 1;
        }

        int a = gcd(N, M, 1);

        return N / a;
    }

    private static int gcd(int a, int b, int res) {
        if (a == b) {
            return res * a;
        } else if ((a % 2 == 0) && (b % 2 == 0)) {
            return gcd(a / 2, b / 2, 2 * res);
        } else if (a % 2 == 0) {
            return gcd(a / 2, b, res);
        } else if (b % 2 == 0) {
            return gcd(a, b / 2, res);
        } else if (a > b) {
            return gcd(a - b, b, res);
        } else {
            return gcd(a, b - a, res);
        }
    }
}
