class pair{
    int r;
    int c;
    int d;
    pair(int r,int c, int d)
    {
        this.r=r;
        this.c=c;
        this.d=d;
    }
}
class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int dist[][]=new int[grid.length][grid.length];
        for(int i=0;i<grid.length;++i)
        {
            Arrays.fill(dist[i],Integer.MAX_VALUE);
        }
        if(grid[0][0]==1||grid[grid.length-1][grid.length-1]==1){return -1;}
        Queue<pair>q=new PriorityQueue<>((a,b)->a.d-b.d);
        dist[0][0]=1;
        q.add(new pair(0,0,1));
        int ro[]={0,1,0,-1,1,1,-1,-1};
        int co[]={1,0,-1,0,1,-1,-1,1};
        while(!q.isEmpty())
        {
            pair temp=q.poll();
            int r=temp.r;
            int c=temp.c;
            for(int i=0;i<8;++i)
            {
                int tr=r+ro[i];
                int tc=c+co[i];
                if(tr>=0&&tr<grid.length&&tc>=0&&tc<grid.length&&grid[tr][tc]==0&&dist[tr][tc]>dist[r][c]+1)
                {
                    dist[tr][tc]=dist[r][c]+1;
                    q.add(new pair(tr,tc,dist[tr][tc]));
                }
            }
        }
        return dist[grid.length-1][grid.length-1]==Integer.MAX_VALUE?-1:dist[grid.length-1][grid.length-1];
    }
}