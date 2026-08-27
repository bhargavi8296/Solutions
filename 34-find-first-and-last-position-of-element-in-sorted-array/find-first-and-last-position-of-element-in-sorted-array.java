class Solution {
    public int[] searchRange(int[] nums, int target) {
        int result[]=new int[2];
        Arrays.fill(result,-1);
        int start=0;
        int end=nums.length-1;
        while(start<=end)
        {
            int mid=(start+end)/2;
            if(nums[mid]>=target){end=mid-1;}
            else{start=mid+1;}
        }
        if(end+1<nums.length&&nums[end+1]==target)
        {
            result[0]=end+1;
        }
        start=0;
        end=nums.length-1;
        while(start<=end)
        {
            int mid=(start+end)/2;
            if(nums[mid]<=target){start=mid+1;}
            else{end=mid-1;}
        }
        if(start-1>=0&&nums[start-1]==target)
        {
            result[1]=start-1;
        }
        return result;
    }
}