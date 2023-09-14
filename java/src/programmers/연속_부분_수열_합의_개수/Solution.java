package programmers.연속_부분_수열_합의_개수;

import java.util.HashSet;
import java.util.Set;

class Solution {
    public int solution(int[] elements) {
        int n = elements.length;
        Set<Integer> mem = new HashSet<>();

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int total = 0;

                for (int k = j; k < j + i; k++) {
                    total += elements[k % n];
                }

                mem.add(total);
            }
        }

        return mem.size() + 1;
    }
}
