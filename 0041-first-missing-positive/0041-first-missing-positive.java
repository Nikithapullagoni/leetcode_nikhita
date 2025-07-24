class Solution {
    public int firstMissingPositive(int[] nums) {
        int i = 0;
        while(i < nums.length){
            if(nums[i] > 0 && nums[i] < nums.length){
                int index = nums[i] - 1;
                if(nums[i] != nums[index]){
                    int temp = nums[i];
                    nums[i] = nums[index];
                    nums[index] = temp;
                }
                else{
                    i++;
                }
            }else{
                i++;
            }
        }
        for(int j = 1; j <= nums.length; j++){
            if(nums[j - 1] != j){
                return j;
            }
        }
        return nums[nums.length - 1] + 1;
    }
}