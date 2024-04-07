package programmers.주차_요금_계산;

import java.util.*;

class Park {
    private final int minMinute;
    private final int termMinute;
    private final int minFee;
    private final int termFee;
    private final Map<String, Integer> cars = new HashMap<>();
    private final Map<String, Integer> minutes = new HashMap<>();

    Park(int minMinute, int termMinute, int minFee, int termFee) {
        this.minMinute = minMinute;
        this.termMinute = termMinute;
        this.minFee = minFee;
        this.termFee = termFee;
    }

    public void in(String id, int minute) {
        cars.put(id, minute);
    }
    
    public void out(String id, int minute) {
        int total = minutes.getOrDefault(id, 0) + (minute - cars.get(id));
        minutes.put(id, total);
        cars.remove(id);
    }

    private int calcFee(int total) {
        int parkMinute = total - minMinute;
        
        if ( parkMinute <= 0) {
            return minFee;
        }
        
        return minFee
               + (parkMinute / termMinute) * termFee
               + (parkMinute % termMinute > 0 ? termFee : 0);
    }
    
    public int[] getFeesArray() {
        List<String> carIds = new ArrayList<>(cars.keySet());
        
        for (String id : carIds) {
            out(id, 1439);
        }
        
        return minutes
            .entrySet()
            .stream().sorted(Comparator.comparing(Map.Entry::getKey))
            .mapToInt(Map.Entry::getValue)
            .map(this::calcFee)
            .toArray();
    }
}

class Solution {
    public int[] solution(int[] fees, String[] records) {
        Park park = new Park(fees[0], fees[2], fees[1], fees[3]);

        for (String record : records) {
            String[] r = record.split(" ");
            
            String mode = r[2];
            String id = r[1];
            int minute = calcMinute(r[0]);
            
            if (mode.equals("IN")) {
                park.in(id, minute);
            } else {
                park.out(id, minute);
            }
        }
        
        return park.getFeesArray();
    }
    
    private int calcMinute(String timeString) {
        String[] hourMinute = timeString.split(":");
        int hour = Integer.parseInt(hourMinute[0]);
        int minute = Integer.parseInt(hourMinute[1]);
        return minute + (hour * 60);
    }
}