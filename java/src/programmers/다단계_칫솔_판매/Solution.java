package programmers.다단계_칫솔_판매;

import java.util.*;

class Solution {
    private static int PRICE = 100;
    private Map<String, Integer> moneys = new HashMap<>();
    private Map<String, String> parantTree = new HashMap<String, String>();

    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        moneys.put("-", 0);

        for(int i = 0; i < enroll.length; i++) {
            String e = enroll[i];
            String r = referral[i];

            moneys.put(e, 0);
            parantTree.put(e, r);
        }

        for(int i = 0; i < seller.length; i++) {
            String child = seller[i];
            int count = amount[i];

            setMoney(child, count * PRICE);
        }

        int[] answer = new int[enroll.length];

        for(int i = 0; i < enroll.length; i++) {
            String name = enroll[i];
            answer[i] = moneys.get(name);
        }

        return answer;
    }

    private void setMoney(String child, int money) {
        int childMoney = moneys.get(child);
        int shareMoney = (int) (money * 0.1);

        if (shareMoney < 1) {
            moneys.put(child, childMoney + money);           
            return;
        }


        moneys.put(child, childMoney + money - shareMoney);

        if (parantTree.containsKey(child)) {
            String parant = parantTree.get(child);
            setMoney(parant, shareMoney);
        }       
    }
}