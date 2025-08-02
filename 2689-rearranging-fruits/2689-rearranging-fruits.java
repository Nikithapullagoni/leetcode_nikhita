import java.util.*;

class Solution {
    public long minCost(int[] basket1, int[] basket2) {
        Map<Integer, Integer> count = new HashMap<>();
        TreeMap<Integer, Integer> freq = new TreeMap<>();

        for (int x : basket1) {
            count.put(x, count.getOrDefault(x, 0) + 1);
            freq.put(x, freq.getOrDefault(x, 0) + 1);
        }

        for (int x : basket2) {
            count.put(x, count.getOrDefault(x, 0) - 1);
            freq.put(x, freq.getOrDefault(x, 0) + 1);
        }
        for (int v : count.values()) {
            if (v % 2 != 0) return -1;
        }

        List<Integer> excess1 = new ArrayList<>();
        List<Integer> excess2 = new ArrayList<>();

        for (Map.Entry<Integer, Integer> e : count.entrySet()) {
            int fruit = e.getKey();
            int diff = e.getValue();

            if (diff > 0) {
                for (int i = 0; i < diff / 2; i++) excess1.add(fruit);
            } else if (diff < 0) {
                for (int i = 0; i < -diff / 2; i++) excess2.add(fruit);
            }
        }
        Collections.sort(excess1);
        Collections.sort(excess2, Collections.reverseOrder());
        int globalMin = freq.firstKey();

        long totalCost = 0;
        for (int i = 0; i < excess1.size(); i++) {
            int a = excess1.get(i);
            int b = excess2.get(i);
            totalCost += Math.min(Math.min(a, b), 2 * globalMin);
        }

        return totalCost;
    }
}
