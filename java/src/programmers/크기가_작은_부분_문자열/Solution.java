package programmers.크기가_작은_부분_문자열;

import java.util.LinkedList;
import java.util.List;

class Solution {
    public int solution(String t, String p) {
        long target = Long.parseLong(p);
        List<Long> numbers = new LinkedList<>();

        try {
            int i = 0;

            while (true) {
                String n = t.substring(i, i + p.length());
                long number = Long.parseLong(n);
                numbers.add(number);
                i++;
            }
        } catch (Exception exception) {}

        return numbers.stream().filter(n -> target >= n).toArray().length;
    }
}