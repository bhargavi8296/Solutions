class Solution {
    public int findPeakElement(int[] nums) {
        for(int i=1;i<nums.length;++i)
        {
            if(nums[i]>nums[i-1]){
                if(i+1<nums.length)
                {
                    if(nums[i]>nums[i+1]){return i;}
                }
                else{
                    return i;
                }
            }
        }
        return 0;
    }
}