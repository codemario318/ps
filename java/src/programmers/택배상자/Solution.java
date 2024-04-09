package programmers.택배상자;

import java.util.*;

class Solution {
    public int solution(int[] order) {
        int answer = 0;

        Queue<Integer> queue = new LinkedList<>();
        Stack<Integer> stack = new Stack<>();

        for (int n = 1; n <= order.length; n++) {
            queue.add(n);
        }

        int i = 0;

        while (!queue.isEmpty() && i < order.length) {
            int target = order[i];

            if (target == queue.peek()) {
                answer++;
                i++;
                queue.poll();
                continue;
            }

            if (!stack.isEmpty() && stack.peek() == target) {
                stack.pop();
                answer++;
                i++;
                continue;
            }

            stack.push(queue.poll());
        }

        while (!stack.isEmpty() && i < order.length) {
            int target = order[i];

            if (stack.peek() != target) {
                break;
            }

            stack.pop();
            answer++;
            i++;
        }

        return answer;
    }
}