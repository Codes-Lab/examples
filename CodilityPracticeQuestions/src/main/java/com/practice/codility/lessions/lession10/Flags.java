package com.practice.codility.lessions.lession10;

import java.util.ArrayList;
import java.util.List;

/**
 * A non-empty array A consisting of N integers is given.
 * <p>
 * A peak is an array element which is larger than its neighbours. More precisely, it is an index P such that 0 < P < N − 1 and A[P − 1] < A[P] > A[P + 1].
 * <p>
 * For example, the following array A:
 * <p>
 * A[0] = 1
 * A[1] = 5
 * A[2] = 3
 * A[3] = 4
 * A[4] = 3
 * A[5] = 4
 * A[6] = 1
 * A[7] = 2
 * A[8] = 3
 * A[9] = 4
 * A[10] = 6
 * A[11] = 2
 * has exactly four peaks: elements 1, 3, 5 and 10.
 * <p>
 * You are going on a trip to a range of mountains whose relative heights are represented by array A, as shown in a figure below. You have to choose how many flags you should take with you. The goal is to set the maximum number of flags on the peaks, according to certain rules.
 * <p>
 * <p>
 * <p>
 * Flags can only be set on peaks. What's more, if you take K flags, then the distance between any two flags should be greater than or equal to K. The distance between indices P and Q is the absolute value |P − Q|.
 * <p>
 * For example, given the mountain range represented by array A, above, with N = 12, if you take:
 * <p>
 * two flags, you can set them on peaks 1 and 5;
 * three flags, you can set them on peaks 1, 5 and 10;
 * four flags, you can set only three flags, on peaks 1, 5 and 10.
 * You can therefore set a maximum of three flags in this case.
 * <p>
 * Write a function:
 * <p>
 * class Solution { public int solution(int[] A); }
 * <p>
 * that, given a non-empty array A of N integers, returns the maximum number of flags that can be set on the peaks of the array.
 * <p>
 * For example, the following array A:
 * <p>
 * A[0] = 1
 * A[1] = 5
 * A[2] = 3
 * A[3] = 4
 * A[4] = 3
 * A[5] = 4
 * A[6] = 1
 * A[7] = 2
 * A[8] = 3
 * A[9] = 4
 * A[10] = 6
 * A[11] = 2
 * the function should return 3, as explained above.
 * <p>
 * Write an efficient algorithm for the following assumptions:
 * <p>
 * N is an integer within the range [1..400,000];
 * each element of array A is an integer within the range [0..1,000,000,000].
 * Copyright 2009–2022 by Codility Limited. All Rights Reserved. Unauthorized copying, publication or disclosure prohibited.
 */
public class Flags {

    public static void main(String[] args) {
        final int[] A = { 1, 5, 3, 4, 3, 4, 1, 2, 3, 4, 6, 2 };
        System.out.println(solution(A));
    }

    private static int solution(int[] A) {
        final List<Integer> peaks = new ArrayList<>();
        for (int i = 1; i < A.length - 1; i++) {
            if (A[i - 1] < A[i] && A[i] > A[i + 1]) {
                peaks.add(i);
            }
        }

        if (peaks.size() <= 1) {
            return peaks.size();
        }

        int maxFlags = (int) Math.sqrt((peaks.get(peaks.size() - 1) - peaks.get(0)));

        for (int flags = maxFlags; flags > 1; flags--) {
            int startIndex = 0;
            int endIndex = peaks.size() - 1;

            int startFlag = peaks.get(startIndex);
            int endFlag = peaks.get(endIndex);

            int flagPlaced = 2;
            while (startIndex < endIndex) {
                startIndex++;
                endIndex--;

                if (peaks.get(startIndex) >= startFlag + flags) {
                    if (peaks.get(startIndex) <= endFlag - flags) {
                        flagPlaced++;
                        startFlag = peaks.get(startIndex);
                    }
                }

                if (peaks.get(endIndex) >= startFlag + flags) {
                    if (peaks.get(endIndex) <= endFlag - flags) {
                        flagPlaced++;
                        endFlag = peaks.get(endIndex);
                    }
                }
                if (flagPlaced == flags) {
                    return flags;
                }
            }
        }
        return 0;
    }
}
