class Solution {
    public int jump(int[] nums) {
        int dp[]=new int[nums.length];
        Arrays.fill(dp,10001);
        dp[nums.length-1]=0;
        for(int i=nums.length-2;i>=0;--i)
        {
            int j=i+1;
            while(j<nums.length&&j<=(i+nums[i]))
            {
                dp[i]=Math.min(dp[i],dp[j]+1);
                //System.out.println(dp[j]+" "+(j+1));
                ++j;
            }   
        }
        return dp[0]>=10001?0:dp[0];
    }
}