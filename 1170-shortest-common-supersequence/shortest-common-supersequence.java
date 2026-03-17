class Solution {
    int dp[][];
    public String shortestCommonSupersequence(String str1, String str2) {
        dp=new int[str1.length()+1][str2.length()+1];
        for(int i=1;i<str1.length()+1;++i)
        {
            for(int j=1;j<str2.length()+1;++j)
            {
                if(str1.charAt(i-1)==str2.charAt(j-1))
                {
                    dp[i][j]=1+dp[i-1][j-1];
                }
                else
                {
                    dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        int i=str1.length();int j=str2.length();
        String res="";
        while(i>0&&j>0)
        {
            
            if(str1.charAt(i-1)==str2.charAt(j-1)){res=str1.charAt(i-1)+res;--i;--j;}
            else
            {
                if(dp[i-1][j]>dp[i][j-1]){res=str1.charAt(i-1)+res;--i;}
                else{res=str2.charAt(j-1)+res;--j;}
            }
        }
       // System.out.println(i+" "+str2.charAt(j)+" "+str2);
        while(i>0){res=str1.charAt(i-1)+res;--i;}
        while(j>0){res=str2.charAt(j-1)+res;--j;}
        return res;
    }
}