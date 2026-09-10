class pair{
    int num;
    int count;
    pair(int num, int count)
    {
        this.num=num;
        this.count=count;
    }
}
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        PriorityQueue<pair>pq=new PriorityQueue<>((a,b)->b.count-a.count);
        Map<Integer,Integer>map=new HashMap<>();
        for(int i=0;i<nums.length;++i)
        {
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }
        //System.out.println(map);
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            pq.add(new pair(entry.getKey(),entry.getValue()));
        }
        int ans[]=new int[k];
        int i=0;
        while(i<k&&!pq.isEmpty())
        {
            ans[i]=pq.poll().num;
            ++i;
        }
        return ans;
    }
}