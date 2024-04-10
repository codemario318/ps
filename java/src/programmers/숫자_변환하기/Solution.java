package programmers.숫자_변환하기;

import java.util.*;

class Solution {
    private int MAX_VALUE = 3_000_001;

    public int solution(int x, int y, int n) {
        int[] mem = new int[y * 3 + 1];

        Arrays.fill(mem, MAX_VALUE);
        mem[x] = 0;

        for(int i = x; i <= y; i++) {
            int cur = mem[i] + 1;
            mem[i * 2] = Math.min(mem[i * 2], cur);
            mem[i * 3] = Math.min(mem[i * 3], cur);
            mem[i + n] = Math.min(mem[i + n], cur);
        }

        return mem[y] != MAX_VALUE ? mem[y] : -1;
    }
}