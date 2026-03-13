class Solution {
    int minCost(int[] height) {
        // code here
        int res[]=new int[height.length];
        if(height.length>1){
            res[height.length-2]=Math.abs(height[height.length-2]-height[height.length-1]);
        }
        for(int i=height.length-3;i>=0;--i)
        {
            res[i]=Math.min(Math.abs(height[i]-height[i+1])+res[i+1],Math.abs(height[i]-height[i+2])+res[i+2]);
        }
        return res[0];
    }
}