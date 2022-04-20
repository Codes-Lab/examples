package com.practice.codility.lessions.lession7;

import java.util.Stack;

/**
 * A string S consisting of N characters is considered to be properly nested if any of the following conditions is true:
 * <p>
 * S is empty;
 * S has the form "(U)" or "[U]" or "{U}" where U is a properly nested string;
 * S has the form "VW" where V and W are properly nested strings.
 * For example, the string "{[()()]}" is properly nested but "([)()]" is not.
 * <p>
 * Write a function:
 * <p>
 * class Solution { public int solution(String S); }
 * <p>
 * that, given a string S consisting of N characters, returns 1 if S is properly nested and 0 otherwise.
 * <p>
 * For example, given S = "{[()()]}", the function should return 1 and given S = "([)()]", the function should return 0, as explained above.
 * <p>
 * Write an efficient algorithm for the following assumptions:
 * <p>
 * N is an integer within the range [0..200,000];
 * string S consists only of the following characters: "(", "{", "[", "]", "}" and/or ")".
 * Copyright 2009–2022 by Codility Limited. All Rights Reserved. Unauthorized copying, publication or disclosure prohibited.
 */
public class Brackets {

    public static void main(String[] args) {
        final String s = "{[()()]}}";
        System.out.println(solution(s));
    }

    private static int solution(String s) {
        final Stack<Character> characterStack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            final char currentChar = s.charAt(i);
            if (isOpenBracket(currentChar)) {
                characterStack.push(currentChar);
            } else if (isCloseBracket(currentChar)) {
                if (characterStack.isEmpty()) {
                    return 0;
                }
                final Character poppedChar = characterStack.pop();
                if (isBracketMatch(poppedChar, currentChar)) {
                    continue;
                }
                return 0;
            }
        }
        if (characterStack.isEmpty()) {
            return 1;
        }
        return 0;
    }

    private static boolean isOpenBracket(char currentChar) {
        return (currentChar == '{' || currentChar == '[' || currentChar == '(');
    }

    private static boolean isCloseBracket(char currentChar) {
        return (currentChar == '}' || currentChar == ']' || currentChar == ')');
    }

    private static boolean isBracketMatch(char poppedChar, char currentChar) {
        return (poppedChar == '[' && currentChar == ']') || (poppedChar == '{' && currentChar == '}') || (poppedChar == '(' && currentChar == ')');

    }

}
