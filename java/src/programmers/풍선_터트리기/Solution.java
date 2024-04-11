package programmers.풍선_터트리기;

import java.util.HashMap;

class Solution {
    public int solution(int[] a) {
        int length = a.length;
        int[] memLeft = new int[length];
        int[] memRight = new int[length];

        memLeft[0] = a[0];

        for(int i = 1; i < length; i++) {
            memLeft[i] = Math.min(a[i], memLeft[i - 1]);
        }

        memRight[length - 1] = a[length - 1];

        for(int i = length - 2; i >= 0; i--) {
            memRight[i] = Math.min(a[i], memRight[i + 1]);
        }

        int count = length;

        for(int i = 0; i < length; i++) {
            if (a[i] > memLeft[i] && a[i] > memRight[i]) {
                count--;
            }
        }

        return count;
    }
}