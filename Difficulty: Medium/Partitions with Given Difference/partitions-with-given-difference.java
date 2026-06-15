class Solution {
    int dp[][];
    public int helper(int arr[], int sum , int i)
    {
       if(i<0){return 0;}
       if(dp[i][sum]!=-1){return dp[i][sum];}
       //System.out.println(sum+" "+arr[i]);
       if(sum>=arr[i])
       {
           if(sum==arr[i])
           {
               return dp[i][sum]= 1+helper(arr,0,i-1)+helper(arr,sum, i-1);
           }
           return dp[i][sum]=helper(arr,sum-arr[i],i-1)+helper(arr,sum, i-1);
       }
       return dp[i][sum]=helper(arr,sum, i-1);
        
    }
    public int countPartitions(int[] arr, int diff) {
        // code here
        int sum=0;
        int count=0;
        for(int val:arr)
        {
            sum+=val;
        }
        sum+=diff;
        if(sum%2!=0){return 0;}
        sum=sum/2;
        dp=new int[arr.length+1][sum+1];
        for(int i=0;i<arr.length+1;++i)
        {
            Arrays.fill(dp[i],-1);
        }
        return helper(arr, sum, arr.length-1);
    }
}
