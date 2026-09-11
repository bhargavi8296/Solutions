class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        Map<Integer,Integer>map=new HashMap<>();
        int sum=0;
        map.put(0,1);
        int result=0;
        for(int val:nums)
        {
            sum+=val;
            if(map.containsKey(sum-goal))
            {
                result+=map.get(sum-goal);
            }
            map.put(sum,map.getOrDefault(sum,0)+1);
            
        }
        return result;
    }
}