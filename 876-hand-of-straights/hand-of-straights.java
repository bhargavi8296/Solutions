class pair{
    int num;int val;
    pair(int num,int val)
    {
        this.num=num;
        this.val=val;
    } 
}
class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        Map<Integer,Integer>map=new HashMap<>();
        for(int i=0;i<hand.length;++i)
        {
            map.put(hand[i],map.getOrDefault(hand[i],0)+1);
        }
        PriorityQueue<pair>p1=new PriorityQueue<>((a,b)->a.num-b.num);
        PriorityQueue<pair>p2=new PriorityQueue<>((a,b)->a.num-b.num);
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            p1.add(new pair(entry.getKey(),entry.getValue()));
        }
        while(!p1.isEmpty())
        {
            int size=groupSize;
                int res=p1.peek().num-1;
                while(size>0&&!p1.isEmpty())
                {
                    pair temp=p1.poll();
                    if(temp.num-1!=res){return false;}
                    res=temp.num;
                    temp.val--;
                    if(temp.val>0)
                    {
                        //System.out.println(temp.num+" "+temp.val);
                        p2.add(temp);
                    }
                    --size;
                }
                if(size>0){return false;}
                p1.addAll(p2);
                p2.clear();
            
        }
        return true;
    }
}