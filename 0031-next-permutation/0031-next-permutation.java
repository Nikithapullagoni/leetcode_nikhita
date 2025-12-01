class Solution {
    public void swap(int[]nums,int start,int end){
        int temp=nums[start];
        nums[start]=nums[end];
        nums[end]=temp;
    }
    public void nextPermutation(int[] nums) {

        int pivot=-1;
        int n=nums.length;

        //Finding the pivot in the array

        for(int i=n-2;i>=0;i--){
            if(nums[i]<nums[i+1]){
                pivot=i;
                break;
            }
        }

        //swaping pivot with just greater number than pivot
        for(int i=n-1;pivot!=-1 && i>pivot;i--){
            
            if(nums[i]>nums[pivot]){
                swap(nums,i,pivot);
                break;
            }
        }

        //reverse all elements after pivot

        int start=pivot+1;
        int end=n-1;

        while(start<=end){
            swap(nums,start,end);
            start++;
            end--;
        }
        
    }
}