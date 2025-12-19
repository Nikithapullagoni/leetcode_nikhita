class Solution {
    public String gcdOfStrings(String str1, String str2) {
        String str3=str2+str1;
        String str4=str1+str2;
        if(!str3.equals(str4)) return "";
        int gcd=gcd(str1.length(),str2.length());
        return str1.substring(0,gcd);
    }
    int gcd(int a,int b){
        int r=1;
        while(r!=0){
            r=a%b;
            a=b;
            b=r;
        }
        return a;
    }
}