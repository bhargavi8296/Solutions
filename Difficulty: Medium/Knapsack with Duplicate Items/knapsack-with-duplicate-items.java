class Solution {
    int dp[][];
    public int helper(int val[],int wt[],int capacity, int i)
    {
        if(capacity==0||i<0){return 0;}
        //System.out.print(capacity+" ");
        if(dp[i][capacity]!=-1){return dp[i][capacity];}
        if(wt[i]<=capacity)
        {
            return dp[i][capacity]=Math.max(helper(val,wt,capacity-wt[i],i)+val[i],helper(val,wt,capacity,i-1));    
        }
        return dp[i][capacity]=helper(val,wt,capacity,i-1);
        
    }
    public int knapSack(int val[], int wt[], int capacity) {
        // code here
        dp=new int[val.length+1][capacity+1];
        for(int i=0;i<val.length+1;++i)
        {
            Arrays.fill(dp[i],-1);
        }
        return helper(val,wt,capacity,val.length-1);
    }
}