class Solution {
    int dp[][];
    public int helper(int[]nums, int i, int j)
    {
        if(i>j){return 0;}
        if(dp[i][j]!=-1){return dp[i][j];}
        int res=0;
        for(int k=i+1;k<j;++k)
        {
            int temp=nums[k]*nums[i]*nums[j];
            temp+=(helper(nums,i,k)+helper(nums,k,j));
            res=Math.max(res,temp);
        }
        return dp[i][j]=res;
    }
    public int maxCoins(int[] nums) {
        int arr[]=new int[nums.length+2];
        arr[0]=1;
        arr[arr.length-1]=1;
        dp=new int[arr.length][arr.length];
        for(int i=0;i<dp.length;++i)
        {
            Arrays.fill(dp[i],-1);
        }
        for(int i=0;i<nums.length;++i)
        {
            arr[i+1]=nums[i];
        }
        return helper(arr,0,arr.length-1);
    }
}

  