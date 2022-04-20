package com.practice.codility.lessions.lession11;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * A prime is a positive integer X that has exactly two distinct divisors: 1 and X. The first few prime integers are 2, 3, 5, 7, 11 and 13.
 * <p>
 * A semiprime is a natural number that is the product of two (not necessarily distinct) prime numbers. The first few semiprimes are 4, 6, 9, 10, 14, 15, 21, 22, 25, 26.
 * <p>
 * You are given two non-empty arrays P and Q, each consisting of M integers. These arrays represent queries about the number of semiprimes within specified ranges.
 * <p>
 * Query K requires you to find the number of semiprimes within the range (P[K], Q[K]), where 1 ≤ P[K] ≤ Q[K] ≤ N.
 * <p>
 * For example, consider an integer N = 26 and arrays P, Q such that:
 * <p>
 * P[0] = 1    Q[0] = 26
 * P[1] = 4    Q[1] = 10
 * P[2] = 16   Q[2] = 20
 * The number of semiprimes within each of these ranges is as follows:
 * <p>
 * (1, 26) is 10,
 * (4, 10) is 4,
 * (16, 20) is 0.
 * Write a function:
 * <p>
 * class Solution { public int[] solution(int N, int[] P, int[] Q); }
 * <p>
 * that, given an integer N and two non-empty arrays P and Q consisting of M integers, returns an array consisting of M elements specifying the consecutive answers to all the queries.
 * <p>
 * For example, given an integer N = 26 and arrays P, Q such that:
 * <p>
 * P[0] = 1    Q[0] = 26
 * P[1] = 4    Q[1] = 10
 * P[2] = 16   Q[2] = 20
 * the function should return the values [10, 4, 0], as explained above.
 * <p>
 * Write an efficient algorithm for the following assumptions:
 * <p>
 * N is an integer within the range [1..50,000];
 * M is an integer within the range [1..30,000];
 * each element of arrays P and Q is an integer within the range [1..N];
 * P[i] ≤ Q[i].
 * Copyright 2009–2022 by Codility Limited. All Rights Reserved. Unauthorized copying, publication or disclosure prohibited.
 */

//TODO
public class CountSemiprimes {
    public static void main(String[] args) {
        final int N = 26;
        final int[] P = { 1, 4, 16 };
        final int[] Q = { 26, 10, 20 };
        System.out.println(Arrays.toString(solution(N, P, Q)));
    }

    private static int[] solution(int N, int[] P, int[] Q) {
        final List<Integer> primeNumbers = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            if (isPrime(i)) {
                primeNumbers.add(i);
            }
        }

        final List<Integer> naturalPrimes = new ArrayList<>();
        for (int i = 0; i < primeNumbers.size(); i++) {
            int primeNumber = primeNumbers.get(0);
            for (int j = 0; j <= i; j++) {
                naturalPrimes.add(primeNumber * primeNumbers.get(j));
            }
        }

        return null;
    }

    private static boolean isPrime(int n) {
        if (n <= 1) {
            return false;
        } else if (n == 2) {
            return true;
        } else if (n % 2 == 0) {
            return false;
        }

        for (int i = 3; i < Math.sqrt(n); i += 2) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}
