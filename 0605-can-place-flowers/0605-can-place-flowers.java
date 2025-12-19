class Solution {
    public boolean canPlaceFlowers(int[] flower, int n) {
        for(int i = 0; i < flower.length; i++) {
            if(flower[i] == 0) {
                boolean left = (i == 0) || (flower[i-1] == 0);
                boolean right = (i == flower.length - 1) || (flower[i+1] == 0);
                if(left && right) {
                    flower[i] = 1;
                    n--;
                }
            }
        }
        return n <= 0; 
    }
}