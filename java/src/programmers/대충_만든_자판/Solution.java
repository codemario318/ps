package programmers.대충_만든_자판;

import java.util.HashMap;

class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        int[] answer = new int[targets.length];
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();

        for (String keys : keymap) {
            for (int i = 0; i < keys.length(); i++) {
                char key = keys.charAt(i);
                int step = i + 1;

                if (map.getOrDefault(key, Integer.MAX_VALUE) >= step) {
                    map.put(key, step);
                }
            }
        }

        for (int i = 0; i < targets.length; i++) {
            int count = 0;
            for (char c : targets[i].toCharArray()) {
                if (!map.containsKey(c)) {
                    count = -1;
                    break;
                }
                count += map.get(c);
            }
            answer[i] = count;
        }

        return answer;
    }
}