class Solution {
    int MOD=1000000007;
    int dp[][][];
    public int gcd(int a, int b)
    {
        if(b==1){return b;}
        if(a%b==0){return b;}
        int res=a%b;
        return gcd(Math.max(res,b),Math.min(res,b));
    }
    public int helper(int[]nums,int i, int g1,int g2)
    {
        if(i>=nums.length){return 0;}
        if(dp[i][g1][g2]!=-1){return dp[i][g1][g2];}
        //System.out.println(i+" "+g1+" "+g2);
        int result=helper(nums,i+1,g1,g2);
        int left=gcd(g1==0?nums[i]:g1,nums[i]);
        int right=gcd(nums[i],g2==0?nums[i]:g2);
        if(left==g2){
            result=(result+(1+helper(nums,i+1,left,g2))%MOD)%MOD;
        }
        else{
            result=(result+helper(nums,i+1,left,g2))%MOD;
        }
        if(right==g1)
        {
            result=(result+(1+helper(nums,i+1,g1,right))%MOD)%MOD;
        }
        else{
            result=(result+helper(nums,i+1,g1,right))%MOD;
        }
        return dp[i][g1][g2]=result;
    }
    public int subsequencePairCount(int[] nums) {
        dp=new int[nums.length+1][201][201];
        for(int i=0;i<nums.length+1;++i)
        {
            for(int j=0;j<201;++j)
            {Arrays.fill(dp[i][j],-1);}
        }
        return helper(nums,0,0,0);
    }
}