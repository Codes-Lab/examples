package com.practice.codility.lessions.lession13;

import java.util.ArrayList;
import java.util.List;

/**
 * The Fibonacci sequence is defined using the following recursive formula:
 * <p>
 * F(0) = 0
 * F(1) = 1
 * F(M) = F(M - 1) + F(M - 2) if M >= 2
 * A small frog wants to get to the other side of a river. The frog is initially located at one bank of the river (position −1) and wants to get to the other bank (position N). The frog can jump over any distance F(K), where F(K) is the K-th Fibonacci number. Luckily, there are many leaves on the river, and the frog can jump between the leaves, but only in the direction of the bank at position N.
 * <p>
 * The leaves on the river are represented in an array A consisting of N integers. Consecutive elements of array A represent consecutive positions from 0 to N − 1 on the river. Array A contains only 0s and/or 1s:
 * <p>
 * 0 represents a position without a leaf;
 * 1 represents a position containing a leaf.
 * The goal is to count the minimum number of jumps in which the frog can get to the other side of the river (from position −1 to position N). The frog can jump between positions −1 and N (the banks of the river) and every position containing a leaf.
 * <p>
 * For example, consider array A such that:
 * <p>
 * A[0] = 0
 * A[1] = 0
 * A[2] = 0
 * A[3] = 1
 * A[4] = 1
 * A[5] = 0
 * A[6] = 1
 * A[7] = 0
 * A[8] = 0
 * A[9] = 0
 * A[10] = 0
 * The frog can make three jumps of length F(5) = 5, F(3) = 2 and F(5) = 5.
 * <p>
 * Write a function:
 * <p>
 * class Solution { public int solution(int[] A); }
 * <p>
 * that, given an array A consisting of N integers, returns the minimum number of jumps by which the frog can get to the other side of the river. If the frog cannot reach the other side of the river, the function should return −1.
 * <p>
 * For example, given:
 * <p>
 * A[0] = 0
 * A[1] = 0
 * A[2] = 0
 * A[3] = 1
 * A[4] = 1
 * A[5] = 0
 * A[6] = 1
 * A[7] = 0
 * A[8] = 0
 * A[9] = 0
 * A[10] = 0
 * the function should return 3, as explained above.
 * <p>
 * Write an efficient algorithm for the following assumptions:
 * <p>
 * N is an integer within the range [0..100,000];
 * each element of array A is an integer that can have one of the following values: 0, 1.
 * Copyright 2009–2022 by Codility Limited. All Rights Reserved. Unauthorized copying, publication or disclosure prohibited.
 */
public class FibFrog {

    List<Integer> fibNums;
    int[] ACopy;
    int target;
    List<Integer> positions = new ArrayList<>();

    public static void main(String[] args) {
        final int[] A = { 0, 0, 0, 1, 1, 0, 1, 0, 0, 0, 0 };
        System.out.println(new FibFrog().solution(A));
    }

    private int solution(int[] A) {
        ACopy = A;
        target = A.length;

        //Get all Fibonacci numbers under Array length(or target of the Frog).
        fibNums = new ArrayList<>();
        fibNums.add(0);
        fibNums.add(1);
        for (int i = 0; ; i++) {
            int nextFibNum = fibNums.get(i) + fibNums.get(i + 1);
            if (nextFibNum <= A.length + 1) {
                fibNums.add(nextFibNum);
            } else {
                break;
            }
        }

        //Starting from current position (-1), try jumps to leaf places with Fibonacci number and count steps.
        int steps = 0;
        positions.add(-1);
        //Continue attempting Jumps while position is not empty.
        while (!positions.isEmpty()) {
            steps++;
            //Attempts one jump and if not reached to the Target then get to the new position.
            if (attemptJump()) {
                return steps;
            }
        }
        return -1;

    }

    private boolean attemptJump() {
        final List<Integer> newPositions = new ArrayList<>();

        //Attempt a jump in reverse fibonacci order, since Frog shall try big jumps first to minimize the Jumps.
        //If Target not reached with jumps then add new position to the position of the Frog.
        for (int position : positions) {
            for (int i = fibNums.size() - 1; i >= 2; i--) {
                int fibNum = fibNums.get(i);

                if (position + fibNum == target) {
                    return true;
                }

                if (position + fibNum < target) {
                    if (ACopy[position + fibNum] == 1) {
                        ACopy[position + fibNum] = 0;
                        newPositions.add(position + fibNum);
                    }
                }
            }
        }
        positions = newPositions;
        return false;
    }

}
