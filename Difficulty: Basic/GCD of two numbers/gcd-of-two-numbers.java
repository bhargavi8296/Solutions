class Solution {
    public static int gcd(int a, int b) {
        // code here
        if(b!=0){
            int max=Math.max(a,b);
            int min=Math.min(a,b);
            a=min;
            b=max%min;
            //System.out.print(a+" "+b);
            return gcd(a,b);
        }
        return a;
    }
}
