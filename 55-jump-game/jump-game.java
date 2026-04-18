class Solution {
    public boolean canJump(int[] nums) {
        int arr[]=new int[nums.length];
        for(int i=nums.length-2;i>=0;--i)
        {
            if(nums[i]<arr[i+1]+1){
                arr[i]=arr[i+1]+1;
            }
        }
        return arr[0]==0;
    }
}