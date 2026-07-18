class Solution {
    public int helper(int a, int b)
    {
        if(b==0){return a;}
        int temp=b;
        return helper(temp,a%b);
    }
    public int findGCD(int[] nums) {
        int min=nums[0];
        int max=nums[0];
        for(int i=0;i<nums.length;++i)
        {
            if (nums[i] < min) {
                min = nums[i];
            }

            if (nums[i] > max) {
                max = nums[i];
            }
        }
        return helper(max,min);
    }
}