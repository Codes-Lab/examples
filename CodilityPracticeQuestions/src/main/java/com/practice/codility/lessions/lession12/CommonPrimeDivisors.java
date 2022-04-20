package com.practice.codility.lessions.lession12;

/**
 * A prime is a positive integer X that has exactly two distinct divisors: 1 and X. The first few prime integers are 2, 3, 5, 7, 11 and 13.
 * <p>
 * A prime D is called a prime divisor of a positive integer P if there exists a positive integer K such that D * K = P. For example, 2 and 5 are prime divisors of 20.
 * <p>
 * You are given two positive integers N and M. The goal is to check whether the sets of prime divisors of integers N and M are exactly the same.
 * <p>
 * For example, given:
 * <p>
 * N = 15 and M = 75, the prime divisors are the same: {3, 5};
 * N = 10 and M = 30, the prime divisors aren't the same: {2, 5} is not equal to {2, 3, 5};
 * N = 9 and M = 5, the prime divisors aren't the same: {3} is not equal to {5}.
 * Write a function:
 * <p>
 * class Solution { public int solution(int[] A, int[] B); }
 * <p>
 * that, given two non-empty arrays A and B of Z integers, returns the number of positions K for which the prime divisors of A[K] and B[K] are exactly the same.
 * <p>
 * For example, given:
 * <p>
 * A[0] = 15   B[0] = 75
 * A[1] = 10   B[1] = 30
 * A[2] = 3    B[2] = 5
 * the function should return 1, because only one pair (15, 75) has the same set of prime divisors.
 * <p>
 * Write an efficient algorithm for the following assumptions:
 * <p>
 * Z is an integer within the range [1..6,000];
 * each element of arrays A and B is an integer within the range [1..2,147,483,647].
 * Copyright 2009–2022 by Codility Limited. All Rights Reserved. Unauthorized copying, publication or disclosure prohibited.
 */
public class CommonPrimeDivisors {
    public static void main(String[] args) {
        final int[] A = { 15, 10, 3 };
        final int[] B = { 75, 30, 5 };
        System.out.println(new CommonPrimeDivisors().solution(A, B));
    }

    private int solution(int[] A, int[] B) {
        int count = 0;
        for (int i = 0; i < A.length; i++) {
            if (hasAllPrimeFactors(A[i], B[i]) && hasAllPrimeFactors(B[i], A[i])) {
                count++;
            }
        }
        return count;
    }

    /**
     * If all the prime factors of Y are factors of X then Y/gcd(x,y) will be 1 or also contains the factors of X.
     *
     * @param x
     * @param y
     * @return
     */
    private boolean hasAllPrimeFactors(int x, int y) {
        if (y == 1) {
            return true;
        }

        final int gcd = gcd(x, y, 1);
        if (gcd == 1) {
            return false;
        }
        return hasAllPrimeFactors(x, y / gcd);
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
