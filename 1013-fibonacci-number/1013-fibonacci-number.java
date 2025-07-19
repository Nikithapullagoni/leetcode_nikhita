class Solution {
    public int fib(int n) {
        if(n == 0 || n == 1){
            return n;
        }

        int[] fibList = new int[n+1];
        fibList[0] = 0;
        fibList[1] = 1;
        for(int i=2; i<=n; i++){
            fibList[i] = fibList[i-1] + fibList[i-2];
        }
        return fibList[n];
    }
}