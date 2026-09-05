class Solution {
    public int countPrimes(int n) {
        int count=0;
        boolean []prime=new boolean[n+1];
        for(int i=2;i<n;++i)
        {
            if((i*(long)(i-1)+i)>n){break;}
            if(prime[i]==true){continue;}
            int start=(i*(i-1))+i;
            for(int j=start;j<=n;j+=i)
            {
                prime[j]=true;
            }
        }
        for(int i=2;i<n;++i)
        {
            if(prime[i]==false){++count;}    
        }
        return count;
    }
}