class Solution {
    static int dp[][];
    static boolean helper(int arr[], int sum, int ind)
    {
        if(sum==0){return true;}
        if(sum<0||ind<0){return false;}
        if(dp[ind][sum]!=-1){return dp[ind][sum]==1?true:false;}
        boolean flag=helper(arr,sum-arr[ind],ind-1)|helper(arr,sum,ind-1);
        dp[ind][sum]=flag==true?1:0;
        return flag;
    }
    static Boolean isSubsetSum(int arr[], int sum) {
        // code here
        dp=new int[arr.length+1][sum+1];
        for(int i=0;i<arr.length+1;++i)
        {
            Arrays.fill(dp[i],-1);
        }
        return helper(arr,sum,arr.length-1);
        
    }
}