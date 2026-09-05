class Solution {
    public double myPow(double x, int n) {
        //System.out.println(n+" "+x);
        if (x < -10000 || x > 10000) {
            return 0;
        }
        if(n==0){return 1;}
        if(n==1){return x;}
        if(n<0)
        {
            x=1/x;
            n=n*(-1);
        }
        if(n%2==0)
        {
            return myPow(x*x,n/2);
        }
        return x*myPow(x*x,n/2);
    }
}