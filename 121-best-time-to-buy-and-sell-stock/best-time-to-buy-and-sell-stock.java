class Solution {
    public int maxProfit(int[] prices) {
        int result=0;
        int first=prices[0];
        for(int i=1;i<prices.length;++i)
        {
            if(first>prices[i])
            {
                first=prices[i];
            }
            else{
                result=Math.max(result,prices[i]-first);
            }
        }
        return result;
    }
}