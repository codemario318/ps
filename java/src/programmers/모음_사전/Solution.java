package programmers.모음_사전;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

class Solution {
    public int solution(String word) {
        Map<Character, Character> nexts = new HashMap<>();
        Stack<Character> target = new Stack<>();
        Stack<Character> temp = new Stack<>();

        nexts.put('A', 'E');
        nexts.put('E', 'I');
        nexts.put('I', 'O');
        nexts.put('O', 'U');
        nexts.put('U', null);

        for (char c : word.toCharArray()) {
            target.push(c);
        }

        int answer = 0;

        while (!target.equals(temp)) {
            if (temp.size() < 5) {
                temp.push('A');
            } else {
                Character cur = temp.pop();
                Character next = nexts.get(cur);
                
                while (!temp.isEmpty() && next == null) {
                    cur =  temp.pop();
                    next = nexts.get(cur);
                }
                
                temp.push(next);
            }
            answer++;
        }
        
        return answer;
    }
}