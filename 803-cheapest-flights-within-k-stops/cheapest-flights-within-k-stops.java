class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<List<int[]>>list=new ArrayList<>();
        for(int i=0;i<n;++i){list.add(new ArrayList<>());}
        for(int i=0;i<flights.length;++i)
        {
            int f=flights[i][0];
            int s=flights[i][1];
            int d=flights[i][2];
            list.get(f).add(new int[]{s,d});
        }
        Queue<int[]>q=new LinkedList<>();
        q.add(new int[]{src,0,k});
        int dist[]=new int[n];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[src]=0;
        while(!q.isEmpty())
        {
            int []temp=q.poll();
            int sr=temp[0];
            int d=temp[1];
            int c=temp[2];
            //System.out.println(sr+" "+d+" "+c);
            //if(sr==dst){return d;}
            if(c<0){continue;}
            for(int t[]:list.get(sr))
            {
                int val=t[0];int di=t[1];
               if(d + di < dist[val])
                {
                    dist[val] = d + di;
                    q.add(new int[]{val,dist[val],c-1});
                }
            }
        }
        return dist[dst]==Integer.MAX_VALUE?-1:dist[dst];
    }
}