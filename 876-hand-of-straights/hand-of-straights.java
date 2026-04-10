class pair{
    int num;
    int val;
    pair(int num, int val)
    {
        this.num=num;
        this.val=val;
    }
}
class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        Queue<pair>q=new PriorityQueue<>((a,b)->a.num-b.num);
        Map<Integer,Integer>map=new HashMap<>();
        if(((hand.length)%groupSize)!=0){return false;}
        if(groupSize==1){return true;}
        for(int val:hand){map.put(val,map.getOrDefault(val,0)+1);}
        for (Map.Entry<Integer, Integer> e : map.entrySet()) {
            q.add(new pair(e.getKey(),e.getValue()));
        }
        int total=hand.length;
        while(!q.isEmpty())
        {
            pair top=q.poll();
            int num=top.num;
            int val=top.val;
            total--;
            int size=Math.min(groupSize-1,q.size());
            if(size<groupSize-1&&size<total){return false;}
            Queue<pair>q1=new PriorityQueue<>((a,b)->a.num-b.num);
            if(val>1){q1.add(new pair(num,val-1));}
            while(size>0)
            {
                pair temp=q.poll();
                total--;
                int num1=temp.num;
                int val1=temp.val;
                //System.out.println(num+" "+num1+" "+val+" "+val1);
                if(num1-num!=1){return false;}
                else{
                    if(val1>1){q1.add(new pair(num1,val1-1));}
                    num=num1;
                }
                --size;
            }
            q.addAll(q1);
        }
        return true;
    }
}