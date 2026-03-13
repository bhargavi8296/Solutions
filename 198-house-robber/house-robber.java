class Solution {
    public int rob(int[] nums) {
        if(nums.length==1){return nums[0];}
        nums[nums.length-2] = Math.max(nums[nums.length-2], nums[nums.length-1]);
        for(int i=nums.length-3;i>=0;--i)
        {
            nums[i]=Math.max(nums[i]+nums[i+2],nums[i+1]);
        }
        return nums[0];
    }
}