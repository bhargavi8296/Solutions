// User function Template for Java

class Solution {
    static boolean prime(int n)
    {
        int count=0;
        for(int i=2;i*i<=n;++i)
        {
            if((n%i)==0){++count;}
            if(count>1){break;}
        }
        return count<1;
    }
    static int largestPrimeFactor(int n) {
        // code here
        int result=2;
        if(prime(n)){return n;}
        for(int i=2;i*i<=n;++i)
        {
            if(n%i==0)
            {
                if(prime(n/i)){result=n/i;break;}
                else if(prime(i))
                {
                    result=i;
                }
            }
        }
        return result;
        
    }
}