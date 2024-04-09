package programmers.택배상자;
import java.util.*;

class Solution {
    public int solution(int[] order) {
        Stack<Integer> stack = new Stack<>();
        int i = 0;

        for (int n = 1; n <= order.length; n++) {
            stack.push(n);

            while(!stack.isEmpty()) {
                if (stack.peek() == order[i]) {
                    stack.pop();
                    i++;
                } else
                    break;
            }
        }

        return i;
    }
}