class Solution {
    int dp[][];
    int[][] pal;
    public int helper(String s, int i, int j)
    {
        if(i>j){return -1;}
        if(dp[i][j]!=-1){return dp[i][j];}
        int res=Integer.MAX_VALUE;
        for(int k=i;k<=j;++k)
        {
            boolean leftPal=true;

            if(pal[i][k]==-1)
            {
                int a=i,b=k;

                while(a<b)
                {
                    if(s.charAt(a)!=s.charAt(b))
                    {
                        leftPal=false;
                        break;
                    }
                    ++a;--b;
                }

                pal[i][k]=leftPal?1:0;
            }

            if(pal[i][k]==1)
            {
                int sum=1+helper(s,k+1,j);
                res=Math.min(res,sum);
            }
        }
        return dp[i][j]=res;
    }
    public int minCut(String s) {
        dp=new int[s.length()+1][s.length()+1];
        pal=new int[s.length()+1][s.length()+1];
        for(int i=0;i<s.length()+1;++i)
        {
            Arrays.fill(dp[i],-1);
            Arrays.fill(pal[i],-1);
        }
        return helper(s,0,s.length()-1);
    }
}