class Solution {
    public boolean canThreePartsEqualSum(int[] arr) {
        int sum=0;
        for(int n:arr){
            sum+=n;
        }
        if(sum%3!=0){
            return false;
        }
        int target=sum/3;
        int currsum=0;
        int count=0;
        for(int i=0;i<arr.length;i++){
            currsum+=arr[i];
            if(currsum==target){
                count++;
                currsum=0;
                if(count==2 && i<arr.length-1){
                    return true;
                }
            }
        }
        return false;
    }
}