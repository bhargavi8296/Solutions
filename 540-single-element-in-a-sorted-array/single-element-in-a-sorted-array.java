class Solution {
    public int singleNonDuplicate(int[] nums) {
        int l=0;
        int h=nums.length-1;
        while(l<h)
        {
            //System.out.println(l+" "+h);
            int mid=(l+h)/2;
            if(mid%2==1)
            {
                if(nums[mid]==nums[mid-1]){l=mid+1;}
                else{
                    h=mid-1;
                }
            }
            else{
                if(nums[mid]==nums[mid+1]){l=mid+2;}
                else{
                    h=mid-1;
                }
            }
        }
        return nums[l];
    }
}