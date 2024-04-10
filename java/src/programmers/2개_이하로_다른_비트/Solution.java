package programmers.2개_이하로_다른_비트;

class Solution {
    public long[] solution(long[] numbers) {
        long[] answer = new long[numbers.length];

        for (int i = 0; i < numbers.length; i++) {
            long x = numbers[i];

            for (long y = x + 1; y < Long.MAX_VALUE; y++) {
                if (getDiffBitCount(x, y) <= 2) {
                    answer[i] = y;
                    break;
                }
            }
        }

        return answer;
    }

    private int getDiffBitCount(long x, long y) {
        long temp = x ^ y;
        int count = 0;

        while (temp > 0) {
            count += temp % 2;
            temp = temp / 2;
        }

        return count;
    }
}