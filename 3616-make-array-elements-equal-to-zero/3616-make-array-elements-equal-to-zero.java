class Solution {
    public int countValidSelections(int[] nums) {
        int n = nums.length;
        int totalSum = 0;
        for (int x : nums) totalSum += x;
        
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) {
                // Try left direction
                if (check(nums, i, -1, totalSum)) ans++;
                // Try right direction
                if (check(nums, i, 1, totalSum)) ans++;
            }
        }
        return ans;
    }
    
    private boolean check(int[] nums, int start, int dir, int totalSum) {
        int n = nums.length;
        int currSum = totalSum;
        int[] arr = nums.clone(); // make copy since we modify
        
        int curr = start;
        while (curr >= 0 && curr < n) {
            if (arr[curr] == 0) {
                curr += dir;
            } else {
                arr[curr]--;
                currSum--;
                dir = -dir; // reverse direction
                curr += dir;
            }
        }
        return currSum == 0; // all elements became zero
    }
}
