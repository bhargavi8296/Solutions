class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        int dist[]=new int[n+1];
        ArrayList<ArrayList<int[]>>list=new ArrayList<>();
        for(int i=0;i<=n;++i){list.add(new ArrayList<>());}
        for(int i=0;i<times.length;++i)
        {
            int f=times[i][0];
            int s=times[i][1];
            int d=times[i][2];
            list.get(f).add(new int[]{s,d});
        }
        Queue<int[]>q=new PriorityQueue<>((a,b)->a[1]-b[1]);
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[k]=0;
        q.add(new int[]{k,0});
        while(!q.isEmpty())
        {
            int[]p=q.poll();
            int f=p[0];
            int d=p[1];
            for(int []t:list.get(f))
            {
                int val=t[0];
                int di=t[1];
                if(dist[val]>d+di)
                {
                    dist[val]=d+di;
                    q.add(new int[]{val,dist[val]});
                }
            }
        }
        int res=-1;
        for(int i=1;i<=n;++i)
        {
            if(dist[i]==Integer.MAX_VALUE){return -1;}
            else{res=Math.max(res,dist[i]);}
        }
        return res;
    }
}