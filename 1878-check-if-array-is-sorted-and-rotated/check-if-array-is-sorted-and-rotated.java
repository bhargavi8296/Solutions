class Solution {
    public boolean check(int[] nums) {
        for(int i=1;i<nums.length;++i)
        {
            if(nums[i-1]>nums[i])
            {
                int j=i+1;
                while(j<nums.length)
                {
                    if(nums[j-1]>nums[j]){return false;}
                    ++j;
                }
                if(nums[i-1]<nums[nums.length-1]||nums[0]<nums[nums.length-1]){
                    return false;}
            }
        }
        return true;
    }
}