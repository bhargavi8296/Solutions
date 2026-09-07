class Solution {
    public boolean canJump(int[] nums) {
        boolean[]flag=new boolean[nums.length];
        flag[nums.length-1]=true;
        for(int i=nums.length-2;i>=0;--i)
        {
            int j=nums[i];
            int t=i;
            while(t+1<nums.length&&t<i+j&&!flag[t]){
                ++t;
            }
            flag[i]=flag[t];
        }
        return flag[0];
    }
}