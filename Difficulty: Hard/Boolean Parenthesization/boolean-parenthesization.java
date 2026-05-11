// User function Template for Java
class Solution {
    static int dp[][][];
    public static int helper(String s, int i, int j, int isTrue)
    {
        if(i>j){return 0;}
        else if(i==j){
            if((s.charAt(i)=='T'&&isTrue==1)||(s.charAt(i)=='F'&&isTrue==0)){return 1;}
            return 0;
        }
        if(dp[i][j][isTrue]!=-1){return dp[i][j][isTrue];}
        int res=0;
        for(int k=i+1;k<j;k=k+2)
        {
            int l=helper(s,i,k-1,1);
            int r=helper(s,k+1,j,1);
            int lf=helper(s,i,k-1,0);
            int rf=helper(s,k+1,j,0);
            int temp=0;
            if(s.charAt(k)=='|'){temp+=(isTrue==1?(l*r+l*rf+r*lf):lf*rf);}
            else if(s.charAt(k)=='&'){temp+=(isTrue==1?(l*r):lf*rf+l*rf+r*lf);}
            else{temp+=(isTrue==1?l*rf+r*lf:rf*lf+r*l);}
            res+=temp;
        }
        return dp[i][j][isTrue]=res;
    }
    static int countWays(String s) {
        // code here
        dp=new int[s.length()+1][s.length()+1][2];
        for(int i=0;i<s.length()+1;++i)
        {
            for(int j=0;j<s.length();++j)
            {
                Arrays.fill(dp[i][j], -1);
            }
            
        }
        return helper(s,0,s.length()-1,1);
    }
}