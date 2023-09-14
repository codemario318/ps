package programmers.가장_가까운_글자;


import java.util.HashMap;

class Solution {
    public int[] solution(String s) {
        int[] answer = new int[s.length()];
        HashMap<Character, Integer> charPositions = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char target = s.charAt(i);
            int position = charPositions.getOrDefault(target, -1);

            if (charPositions.containsKey(target)) {
                answer[i] = i - position;
            } else {
                answer[i] = -1;
            }

            charPositions.put(target, i);
        }

        return answer;
    }
}