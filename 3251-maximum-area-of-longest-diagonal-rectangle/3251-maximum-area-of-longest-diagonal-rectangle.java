class Solution {
    public int areaOfMaxDiagonal(int[][] dimensions) {
        int maxDiagSq = 0; 
        int maxArea = 0;   

        for (int[] rect : dimensions) {
            int l = rect[0], w = rect[1];
            int diagSq = l * l + w * w;
            int area = l * w;

            if (diagSq > maxDiagSq) {
                maxDiagSq = diagSq;
                maxArea = area;
            } else if (diagSq == maxDiagSq && area > maxArea) {
                maxArea = area;
            }
        }

        return maxArea;
    }
}
