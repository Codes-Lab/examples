////////////////////////////////////////////////////////////////////////////////
//
// Created by AMundewal on 16.04.2022.
//
// Copyright (c) 2006 - 2022 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////

package com.practice.codility.lessions.lession7;

import java.util.Stack;

/**
 *
 */
public class StoneWall {

    public static void main(String[] args) {
        final int[] H = { 8, 8, 5, 7, 9, 8, 7, 4, 8 };
        System.out.println(solution(H));
    }

    public static int solution(int[] H) {

        //Main idea: need to use "stack" to check when we need a new block

        final Stack<Integer> st = new Stack<>();
        int numBlock = 0;

        //Note: H[i] is the ith height of the wall
        for (int i = 0; i < H.length; i++) {

            //Step 1: "If Stack is not empty" AND "from high to low"
            //Then, "pop" (it is the key point, be careful)
            while (!st.isEmpty() && st.peek() > H[i]) {
                st.pop();
            }
            //Step 2: if the stack is empty OR "from low to high"
            if (st.isEmpty() || st.peek() < H[i]) {
                numBlock++;     //Add a block
                st.push(H[i]);  //Push the height
            }
            //Step 3: the height is the same: do nothing
        }

        return numBlock;
    }
}
