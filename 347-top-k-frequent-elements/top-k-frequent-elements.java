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
        Queue<pair>q=new PriorityQueue<>((a,b)->a.count-b.count);
        Map<Integer,Integer>map=new HashMap<>();
        for(int val:nums)
        {
            map.put(val,map.getOrDefault(val,0)+1);
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if(q.size()<k)
            {q.add(new pair(entry.getKey(),entry.getValue()));}
            else if(q.peek().count<entry.getValue()){
                q.poll();q.add(new pair(entry.getKey(),entry.getValue()));
            }
        }
        int result[]=new int[k];
        int i=k-1;
        while(!q.isEmpty())
        {
            result[i]=q.poll().num;--i;
        }
        return result;
    }
}