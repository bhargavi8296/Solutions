class Solution {
    public int[] rearrangeArray(int[] nums) {
        int result[]=new int[nums.length];
        int i=0;int j=0;
        int k=1;
        while(i<nums.length)
        {
            if(nums[i]>=0){
                result[j]=nums[i];
                j+=2;
            }
            else{
                result[k]=nums[i];
                k+=2;
            }
            ++i;
        }
        return result;
    }
}