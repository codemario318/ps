package programmers.2개_이하로_다른_비트;

class Solution {
    public long[] solution(long[] numbers) {
        long[] answer = new long[numbers.length];

        for (int i = 0; i < numbers.length; i++) {
            long number = numbers[i];
            answer[i] = number + (number % 2 == 0 ? 1 : get(number));
        }

        return answer;
    }

    private long get(long n) {
        int count = -1;

        while (n % 2 == 1) {
            count++;
            n /= 2;
        }

        return (long) Math.pow(2, count);
    }
}