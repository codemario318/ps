package programmers.카드_뭉치;

class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        int i = 0;
        int j = 0;

        for (String word : goal) {
            if (i < cards1.length && word.equals(cards1[i])) {
                i++;
                continue;
            }

            if (j < cards2.length && word.equals(cards2[j])) {
                j++;
                continue;
            }

            return "No";
        }

        return "Yes";
    }
}