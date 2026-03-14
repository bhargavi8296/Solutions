// User function Template for Java
class Solution {
    static boolean armstrongNumber(int n) {
        // code here
        int t=n;
        long res=0;
        int len=(n+"").length();
        while(n>0)
        {
            int temp=n%10;n=n/10;
            res+=Math.pow(temp,len);
            if(res>=Integer.MAX_VALUE||res<=Integer.MIN_VALUE){return false;}
        }
        
        return t==res;
    }
}