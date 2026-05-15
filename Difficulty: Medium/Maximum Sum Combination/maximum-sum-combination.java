class pair{
    int val;
    int i1;
    int i2;
    pair(int val, int i1, int i2)
    {
        this.val=val;
        this.i1=i1;
        this.i2=i2;
    }
}
class Solution {
    public ArrayList<Integer> topKSumPairs(int[] a, int[] b, int k) {
        // code here
        Arrays.sort(a);
        Arrays.sort(b);
        int i=a.length-1;
        int j=b.length-1;
        Set<String>set=new HashSet<>();
        Queue<pair>q=new PriorityQueue<>((c,d)->d.val-c.val);
        q.add(new pair(a[i]+b[j],i,j));
        set.add(i+","+j);
        ArrayList<Integer>list=new ArrayList<>();
        while(k>0&&!q.isEmpty())
        {
            pair p=q.poll();
            int val=p.val;
            int i1=p.i1;
            int i2=p.i2;
            list.add(val);
            if(i1-1>=0){
                if(!set.contains((i1-1)+","+i2))
                {
                    q.add(new pair(a[i1-1]+b[i2],i1-1,i2));
                    set.add((i1-1)+","+i2);
                }
            }
            if(i2-1>=0){
                if(!set.contains(i1+","+(i2-1)))
                {
                    q.add(new pair(a[i1]+b[i2-1],i1,i2-1));
                    set.add(i1+","+(i2-1));
                }
            }
            --k;
        }
        return list;
        
    }
}
