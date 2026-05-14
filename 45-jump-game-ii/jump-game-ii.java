class Solution {
    public int jump(int[] nums) {
        int l=0;
        int r=0;
        int jumps=0;
        while(r<nums.length-1)
        {
            //System.out.println(l+" "+r);
            int far=0;
            for(int i=l;i<=r;++i)
            {
                //System.out.println(nums[i]+l);
                far=Math.max(far,nums[i]+i);
            }
            l=r+1;
            r=far;jumps+=1;
        }
        return jumps;
    }
}