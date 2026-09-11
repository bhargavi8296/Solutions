class Solution {
    public int helper(int nums[],int k)
    {
        int i=0;int j=0;
        int count=0;
        int result=0;
        while(j<nums.length)
        {
            if(nums[j]%2==1){++count;}
            while(count>k)
            {
                if(nums[i]%2==1){--count;}
                ++i;
            }
            result+=(j-i+1);
            ++j;
        }
        return result;
    }
    public int numberOfSubarrays(int[] nums, int k) {
        return helper(nums,k)-helper(nums,k-1);
    }
}