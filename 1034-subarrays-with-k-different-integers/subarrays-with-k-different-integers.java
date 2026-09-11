class Solution {
    public int helper(int nums[],int k)
    {
        int i=0;int j=0;
        Map<Integer,Integer>map=new HashMap<>();
        int result=0;
        while(j<nums.length)
        {
            map.put(nums[j],map.getOrDefault(nums[j],0)+1);
            while(map.size()>k)
            {
                map.put(nums[i],map.get(nums[i])-1);
                if(map.get(nums[i])==0){map.remove(nums[i]);}
                ++i;
            }
            result+=(j-i+1);
            ++j;
        }
        return result;
    }
    public int subarraysWithKDistinct(int[] nums, int k) {
        return helper(nums,k)-helper(nums,k-1);

    }
}