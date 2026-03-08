class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int dist[][]=new int[n][n];
        for(int i=0;i<n;++i)
        {
            Arrays.fill(dist[i],Integer.MAX_VALUE);
            dist[i][i]=0;
        }
        for(int i=0;i<edges.length;++i)
        {
            int f=edges[i][0];int s=edges[i][1];int d=edges[i][2];
            dist[f][s]=d;dist[s][f]=d;
        }
        for(int k=0;k<n;++k)
        {
            for(int i=0;i<n;++i)
            {
                for(int j=0;j<n;++j)
                {
                    if(dist[i][k]!=Integer.MAX_VALUE&&dist[j][k]!=Integer.MAX_VALUE&&dist[i][j]>dist[i][k]+dist[k][j])
                    {
                        dist[i][j]=dist[i][k]+dist[k][j];
                    }
                }
            }
        }
        int res=n;
        int result=0;
        for(int i=0;i<n;++i)
        {
            int count=0;
            for(int j=0;j<n;++j)
            {
                //System.out.print(dist[i][j]+" ");
                if(dist[i][j]<=distanceThreshold)
                {
                    ++count;
                }
            }System.out.println();
            if(res>=count)
                {
                    res=count;
                    result=i;
                }
        }
        return result;
    }
}