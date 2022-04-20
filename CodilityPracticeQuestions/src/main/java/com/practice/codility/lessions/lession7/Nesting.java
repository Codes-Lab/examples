package com.practice.codility.lessions.lession7;

import java.util.Stack;

/**
 * A string S consisting of N characters is called properly nested if:
 * <p>
 * S is empty;
 * S has the form "(U)" where U is a properly nested string;
 * S has the form "VW" where V and W are properly nested strings.
 * For example, string "(()(())())" is properly nested but string "())" isn't.
 * <p>
 * Write a function:
 * <p>
 * class Solution { public int solution(String S); }
 * <p>
 * that, given a string S consisting of N characters, returns 1 if string S is properly nested and 0 otherwise.
 * <p>
 * For example, given S = "(()(())())", the function should return 1 and given S = "())", the function should return 0, as explained above.
 * <p>
 * Write an efficient algorithm for the following assumptions:
 * <p>
 * N is an integer within the range [0..1,000,000];
 * string S consists only of the characters "(" and/or ")".
 * Copyright 2009–2022 by Codility Limited. All Rights Reserved. Unauthorized copying, publication or disclosure prohibited.
 */
public class Nesting {
    public static void main(String[] args) {
        final String s = "(((U))";
        System.out.println(solution(s));
    }

    private static int solution(String s) {
        final Stack<Character> characters = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char currentChar = s.charAt(i);
            if (isOpenBracket(currentChar)) {
                characters.push(currentChar);
            } else if (isCloseBracket(currentChar)) {
                if (characters.isEmpty()) {
                    return 0;
                }
                final Character peekedChar = characters.peek();
                if (isOpenBracket(peekedChar)) {
                    characters.pop();
                }
            }
        }
        if (characters.isEmpty()) {
            return 1;
        }
        return 0;
    }

    private static boolean isOpenBracket(char currentChar) {
        return (currentChar == '(');
    }

    private static boolean isCloseBracket(char currentChar) {
        return (currentChar == ')');
    }
}
