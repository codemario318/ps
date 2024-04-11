package programmers.다단계_칫솔_판매;

import java.util.*;

class Member {
    static final double SHARE_RATE = 0.1;

    private Member parant;
    private int money;

    Member(Member parant, int money) {
        this.parant = parant;
        this.money = money;
    }

    public int getMoney() {
        return money;
    }

    public void addMoney(int money) {
        int share = (int) (money * SHARE_RATE);

        this.money += money - share;

        if (share > 0 && parant != null) {
            parant.addMoney(share);
        }
    }
}

class Solution {
    private static final int PRICE = 100;
    private Map<String, Member> members = new HashMap<>();

    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        members.put("-", new Member(null, 0));

        for(int i = 0; i < enroll.length; i++) {
            String childName = enroll[i];
            String parantName = referral[i];

            Member child = new Member(members.get(parantName), 0);

            members.put(childName, child);
        }

        for(int i = 0; i < seller.length; i++) {
            String name = seller[i];
            int count = amount[i];

            members.get(name).addMoney(count * PRICE);
        }

        return Arrays.stream(enroll)
            .mapToInt(name -> members.get(name).getMoney())
            .toArray();
    }
}