class Solution {
    public boolean check(int[] nums) {
        int ind=0;
        for(int i=1;i<nums.length;++i)
        {
            if(nums[ind]>nums[i])
            {
                ind=i;
            }
            else if(nums[ind]==nums[i])
            {
                if(nums[i-1]!=nums[i])
                {
                    ind=i;
                }
            }
        }
        int count=0;
        while(count<nums.length-1)
        {
            if(nums[(ind+1)%nums.length]<nums[ind])
            {
                return false;
            }
            ind=(ind+1)%nums.length;++count;
        }
        return true;
    }
}