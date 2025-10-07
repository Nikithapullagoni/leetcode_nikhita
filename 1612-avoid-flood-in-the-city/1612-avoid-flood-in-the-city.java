import java.util.*;

class Solution {
    public int[] avoidFlood(int[] rains) {
        int n = rains.length;
        int[] ans = new int[n];
        Map<Integer, Integer> fullLakes = new HashMap<>(); // lake -> day it was last filled
        TreeSet<Integer> dryDays = new TreeSet<>(); // indices of days we can dry
       
        for (int i = 0; i < n; i++) {
            int lake = rains[i];
            if (lake == 0) {
                dryDays.add(i);
                ans[i] = 1; // default, may update later
            } else {
                ans[i] = -1; // raining day
                if (fullLakes.containsKey(lake)) {
                    // find the next dry day after the last time this lake was filled
                    Integer dryDay = dryDays.higher(fullLakes.get(lake));
                    if (dryDay == null) {
                        // no day to dry this lake -> flood
                        return new int[0];
                    }
                    // dry this lake on that day
                    ans[dryDay] = lake;
                    dryDays.remove(dryDay);
                }
                // mark the current lake as full
                fullLakes.put(lake, i);
            }
        }
        return ans;
    }
}
