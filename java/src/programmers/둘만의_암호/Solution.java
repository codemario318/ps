package programmers.둘만의_암호;

class Solution {
    public String solution(String s, String skip, int index) {
        StringBuilder answer = new StringBuilder();
        String alphabet = "abcdefghijklmnopqrstuvwxyz"
                .replaceAll("[" + skip + "]", "");

        for (char c : s.toCharArray()) {
            int i = (alphabet.indexOf(c) + index) % alphabet.length();
            answer.append(alphabet.charAt(i));
        }

        return answer.toString();
    }
}