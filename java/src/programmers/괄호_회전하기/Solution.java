package programmers.괄호_회전하기;

import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;

        for (int i = 0; i < s.length(); i++) {
            s = rotate(s);
            if (collect(s.toCharArray())) {
                answer++;
            }
        }

        return answer;
    }

    private String rotate(String s) {
        StringBuilder b = new StringBuilder();

        for (int i = 1; i < s.length(); i++) {
            b.append(s.charAt(i));
        }

        b.append(s.charAt(0));

        return b.toString();
    }

    private boolean collect(char[] s) {
        Map<Character, Character> map = new HashMap<>();
        map.put('(', ')');
        map.put('{', '}');
        map.put('[', ']');


        Stack<Character> stack = new Stack<>();

        for (char c : s) {
            if (stack.isEmpty()) {
                stack.add(c);
                continue;
            }

            if (map.getOrDefault(stack.peek(), '#') == c) {
                stack.pop();
            } else {
                stack.add(c);
            }
        }

        return stack.size() == 0;
    }
}