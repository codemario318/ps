package programmers.귤_고르기;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

class Solution {
    public int solution(int k, int[] tangerine) {
        Map<Integer, Integer> counter = new HashMap<>();

        for (int key : tangerine) add(counter, key);

        int answer = 0;

        for (Integer value : counter.values()) {
            System.out.println(value);
        }

        Integer[] sortedTangerine = counter
                .values()
                .stream()
                .sorted(Comparator.reverseOrder())
                .toArray(Integer[]::new);

        for (int count : sortedTangerine) {
            answer++;
            k -= count;

            if (k <= 0) break;
        }

        return answer;
    }

    private void add(Map<Integer, Integer> map, int key) {
        int count = map.getOrDefault(key, 0) + 1;
        map.put(key, count);
    }
}
