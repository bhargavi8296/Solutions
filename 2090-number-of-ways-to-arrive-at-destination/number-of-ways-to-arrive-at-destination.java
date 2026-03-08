class Solution {
    public int countPaths(int n, int[][] roads) {
        Queue<long[]>q=new PriorityQueue<>((a,b)->Long.compare(a[1],b[1]));
        List<List<long[]>>list=new ArrayList<>();
        for(int i=0;i<n;++i){list.add(new ArrayList<>());}
        for(int i=0;i<roads.length;++i)
        {
            int f=roads[i][0];
            int s=roads[i][1];
            int d=roads[i][2];
            list.get(f).add(new long[]{s,d});
            list.get(s).add(new long[]{f,d});
        }
        long dist[]=new long[n];
        int res[]=new int[n];
        Arrays.fill(dist,Long.MAX_VALUE);
        q.add(new long[]{0,0});
        dist[0]=0;
        res[0]=1;
        while(!q.isEmpty())
        {
            long[]p=q.poll();
            int sr=(int)p[0];
            long d=p[1];
            for(long []t:list.get(sr))
            {
                int val=(int)t[0];
                long di=t[1];
                if(dist[val]>d+di)
                {
                    dist[val]=d+di;
                    q.add(new long[]{val,dist[val]});
                    res[val]=res[sr];
                }
                else if(dist[val]==d+di)
                {
                    res[val]=(res[val]+res[sr])%1000000007;
                }
            }
        }
        return res[n-1];
    }
}