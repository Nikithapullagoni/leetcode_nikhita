class Solution {
    public int[] productExceptSelf(int[] nums) {

        int n = nums.length;
        int pre = 1;
        int post = 1;
        int[] ans = new int[n]; 
        

        for(int i=0; i<n; i++){
            ans[i] = pre;
            pre = pre*nums[i];
        }
        
        for(int i=n-1; i>=0; i--){
            ans[i] = ans[i]*post;
            post = post*nums[i];
        }

        return ans;
    }
}