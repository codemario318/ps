package programmers.연속_펄스_부분_수열의_합;

class Solution {
    public long solution(int[] sequence) {
        int[] pulseSequenceP = getPulseSequence(sequence, 1);
        int[] pulseSequenceM = getPulseSequence(sequence, -1);

        return Math.max(
                getMax(pulseSequenceP),
                getMax(pulseSequenceM)
        );
    }

    private int[] getPulseSequence(int[] s, int m) {
        int[] ps = new int[s.length];

        for (int i = 0; i < ps.length; i++) {
            ps[i] = s[i] * m;
            m *= -1;
        }

        return ps;
    }

    private long getMax(int[] sq) {
        long max = sq[0];
        long[] mem = new long[sq.length];

        mem[0] = sq[0];

        for (int i = 1; i < sq.length; i++) {
            mem[i] = Math.max(mem[i - 1] + sq[i], sq[i]);
            max = Math.max(max, mem[i]);
        }

        return max;
    }
}