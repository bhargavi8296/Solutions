class Solution {
    public int findMin(int[] nums) {
        int l=0;
        int h=nums.length-1;
        int result=5001;
        while(l<=h)
        {
            if(nums[l]<=nums[h]){result=Math.min(result,nums[l]);break;}
            int mid=(l+h)/2;
            if(nums[l]<=nums[mid]){l=mid+1; result=Math.min(result,nums[l]);}
            else{
                result=Math.min(result,nums[mid]);
                h=mid-1;
            }
        }
        return result;
    }
}