class Solution {
    public void rotate(int[] nums, int k) {
        k=nums.length-(k)%nums.length;
        int n_a[]=new int[nums.length];
        for(int i=0;i<nums.length;++i)
        {
            n_a[i]=nums[(i+k)%nums.length];
        }
        for(int i=0;i<nums.length;++i)
        {
            nums[i]=n_a[i];
        }
    }
}