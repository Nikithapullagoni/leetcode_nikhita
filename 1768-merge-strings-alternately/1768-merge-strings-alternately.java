class Solution {
    public String mergeAlternately(String word1, String word2) {
        int n1 = word1.length() ;
        int n2 = word2.length() ;
        StringBuilder ans = new StringBuilder() ;
        int i = 0 , j = 0 ;
        while(i < n1 || j < n2){
            if(i < n1)
                ans.append(word1.charAt(i++)) ;
            if(j < n2)
                ans.append(word2.charAt(j++)) ;
        }
        return ans.toString() ;
    }
}