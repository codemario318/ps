package programmers.숫자_변환하기;

import java.util.*;

class Solution {
    Queue<int[]> queue = new LinkedList<>();
    Set<Integer> visited = new HashSet<>();

    public int solution(int x, int y, int n) {
        push(x, 0);

        while(!queue.isEmpty()) {
            int[] item = queue.poll();
            int num = item[0];
            int count = item[1];

            if (num == y) {
                return count;
            }

            if (num > y) {
                continue;
            }

            push(num * 2, count + 1);
            push(num * 3, count + 1);
            push(num + n, count + 1);
        }

        return -1;
    }

    private void push(int value, int count) {
        if (visited.contains(value)) 
            return;

        queue.add(new int[]{value, count});
        visited.add(value);
    }
}