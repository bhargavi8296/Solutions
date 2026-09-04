class Solution {
    public int longestOnes(int[] nums, int k) {
        int i=0;
        int j=0;
        int res=0;
        while(j<nums.length)
        {
            while(j<nums.length&&(k>0||(k>=0&&nums[j]==1)))
            {
                if(nums[j]!=1){--k;}
                ++j;
            }
            //System.out.println(j+" "+i+" ");
            res=Math.max(res,(j-i));
            while(i<nums.length&&nums[i]==1)
            {
                ++i;
            }
            if(i<nums.length&&nums[i]==0)
            {
                ++k;
                ++i;
            }
        }
        return res;
    }
}