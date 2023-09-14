package programmers.이진_변환_반복하기;

class Solution {
    public int[] solution(String s) {
        int count = 0;
        int removeCount = 0;

        while (!s.equals("1")) {
            String binary = s.replace("0", "");

            removeCount += s.length() - binary.length();
            s = Integer.toBinaryString(binary.length());
            count++;
        }

        return new int[] { count, removeCount };
    }
}