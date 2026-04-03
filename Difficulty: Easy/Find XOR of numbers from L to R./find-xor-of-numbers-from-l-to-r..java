// User function Template for Java

class Solution {
    public static int helper(int l)
    {
        if(l%4==1){return 1;}
        if(l%4==2){return l+1;}
        if(l % 4 == 3) return 0;
        return l;
    }
    public static int findXOR(int l, int r) {
        return helper(l-1)^helper(r);
    }
}