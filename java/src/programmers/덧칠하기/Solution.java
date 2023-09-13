package programmers.덧칠하기;

class Solution {
    public int solution(int n, int m, int[] section) {
        int count = 1;
        int prev = section[0];

        for (int cur : section) {
            if (cur < prev + m) {
                continue;
            } else {
                count++;
                prev = cur;
            }
        }

        return count;
    }
}