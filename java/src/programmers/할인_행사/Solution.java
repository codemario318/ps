package programmers.할인_행사;

import java.util.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        Map<String, Integer> counter = new HashMap<>();
        Queue<String> queue = new LinkedList<>();

        for (int i = 0; i < want.length; i++) {
            counter.put(want[i], number[i]);
        }

        for (int i = 0; i < discount.length; i++) {
            String d = discount[i];
            int count = counter.getOrDefault(d, Integer.MIN_VALUE);

            queue.add(d);

            if (count != Integer.MIN_VALUE) {
                counter.put(d, count - 1);
            }

            if (queue.size() > 10) {
                String item = queue.poll();
                int c = counter.getOrDefault(item, Integer.MIN_VALUE);

                if (c != Integer.MIN_VALUE) counter.put(item, c + 1);
            }

            if (allBuyWant(counter)) {
                answer++;
            }
        }

        return answer;
    }

    private boolean allBuyWant(Map<String, Integer> counter) {
        int count = 0;

        for (Integer want : counter.values()) {
            count += (want > 0) ? 1 : 0;
        }

        return count == 0;
    }
}