class Solution {
    public int minimumTeachings(int n, int[][] languages, int[][] friendships) {
        int m = languages.length;
        
        HashSet<Integer>[] userLang = new HashSet[m + 1];
        for (int i = 1; i <= m; i++) {
            userLang[i] = new HashSet<>();
            for (int lang : languages[i - 1]) {
                userLang[i].add(lang);
            }
        }

        HashSet<Integer> problemUsers = new HashSet<>();
        for (int[] f : friendships) {
            int u = f[0], v = f[1];
            if (!canCommunicate(userLang[u], userLang[v])) {
                problemUsers.add(u);
                problemUsers.add(v);
            }
        }

        if (problemUsers.isEmpty()) return 0;

        int minTeach = Integer.MAX_VALUE;
        for (int lang = 1; lang <= n; lang++) {
            int count = 0;
            for (int user : problemUsers) {
                if (!userLang[user].contains(lang)) {
                    count++;
                }
            }
            minTeach = Math.min(minTeach, count);
        }

        return minTeach;
    }

    private boolean canCommunicate(HashSet<Integer> set1, HashSet<Integer> set2) {
        for (int lang : set1) {
            if (set2.contains(lang)) return true;
        }
        return false;
    }
}
