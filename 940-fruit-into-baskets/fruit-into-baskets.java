class Solution {
    public int totalFruit(int[] nums) {
        int i=0;
        int j=0;
        Map<Integer,Integer>map=new HashMap<>();
        int max=0;
        while(j<nums.length)
        {
            while(j<nums.length&&map.size()<=2)
            {
                
                map.put(nums[j],map.getOrDefault(nums[j],0)+1);++j;
            }
            if(map.size()>2)
            {max=Math.max(max,j-1-i);}
            else{
                max=Math.max(max,j-i);
            }
            //System.out.println(map+" "+j+" "+i);
            while(map.size()>2)
            {
                map.put(nums[i],map.get(nums[i])-1);
                if(map.get(nums[i])==0)
                {
                    map.remove(nums[i]);
                }
                ++i;
            }

        }
        return max;
    }
}