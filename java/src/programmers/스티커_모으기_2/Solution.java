package programmers.스티커_모으기_2;

/*
dp[count][index] = max(dp[count - 1][(index - 2) % len], dp[count - 1][(index - 3) % len])
*/

class Solution {
    public Long solution(int sticker[]) {
        long answer = 0;
        int length = sticker.length;

        if (length == 1) {
            return (long) sticker[0];
        }

        long[] mem = new long[length];

        mem[0] = sticker[0];
        mem[1] = sticker[0];

        for (int i = 2; i < length - 1; i++) {
            mem[i] = Long.max(sticker[i] + mem[i - 2], mem[i - 1]);
        }

        answer = mem[length - 2];

        mem = new long[length];

        mem[1] = sticker[1];

        for (int i = 2; i < sticker.length; i++) {
            mem[i] = Long.max(sticker[i] + mem[i - 2], mem[i - 1]);
        }

        return Long.max(answer, mem[length - 1]);
    }
}