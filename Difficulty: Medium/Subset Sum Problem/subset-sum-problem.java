class Solution {
    static int dp[][];
    static boolean helper(int arr[], int sum ,int i)
    {
        if(sum==0){return true;}
        if(i<0){return false;}
        if(dp[i][sum]!=-1)
        {
            return dp[i][sum]==1?true:false;
        }
        boolean flag;
        if(sum>=arr[i])
        {
            flag= helper(arr,sum-arr[i],i-1)|helper(arr,sum,i-1);
            dp[i][sum]=flag==true?1:0;
            return flag;
        }
        flag= helper(arr,sum, i-1);
        dp[i][sum]=flag==true?1:0;
        return flag;
    }
    static Boolean isSubsetSum(int arr[], int sum) {
        // code here
        dp=new int[arr.length+1][sum+1];
        for(int i=0;i<arr.length;++i)
        {
            Arrays.fill(dp[i],-1);
        }
        return helper(arr,sum, arr.length-1);
        
    }
}