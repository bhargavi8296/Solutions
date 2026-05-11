class Solution {
    static int dp[][];
    static int helper(int arr[], int i, int j)
    {
        if(i==j){return 0;}
        if(dp[i][j]!=-1){return dp[i][j];}
        int res=Integer.MAX_VALUE;
       
            for(int k=i;k<j;++k)
            {
                int temp=arr[i-1]*arr[k]*arr[j];
                int first=helper(arr,i,k);
                int sec=helper(arr,k+1,j);
                res=Math.min(res,temp+first+sec);
            }
        
        return dp[i][j]=res;
    }
    static int matrixMultiplication(int arr[]) {
        // code here
        dp=new int[arr.length+1][arr.length+1];
        for(int i=0;i<dp.length;++i)
        {
            Arrays.fill(dp[i],-1);
        }
        int result=helper(arr,1,arr.length-1);
        
        return result;
        
    }
}