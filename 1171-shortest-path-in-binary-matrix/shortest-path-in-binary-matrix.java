class pair{
    int r;
    int c;
    int d;
    pair(int r,int c,int d)
    {
        this.r=r;
        this.c=c;
        this.d=d;
    }
}
class Solution {
    int dist[][];
    public int shortestPathBinaryMatrix(int[][] grid) {
        dist=new int[grid.length][grid[0].length];
        for(int i=0;i<grid.length;++i)
        {
            Arrays.fill(dist[i],Integer.MAX_VALUE);
        }
        Queue<pair>q=new LinkedList<>();
        if(grid[0][0]==0){dist[0][0]=1;q.add(new pair(0,0,1));}
        while(!q.isEmpty())
        {
            pair p=q.poll();
            int r=p.r;
            int c=p.c;
            int d=p.d;
            int ro[]={0,1,0,-1,1,1,-1,-1};
            int co[]={1,0,-1,0,1,-1,1,-1};
            for(int i=0;i<8;++i)
            {
                int tr=ro[i]+r;
                int tc=co[i]+c;
                if(tr>=0&&tr<grid.length&&tc>=0&&tc<grid[0].length&&grid[tr][tc]==0&&dist[tr][tc]>d+1)
                {
                    dist[tr][tc]=d+1;
                    q.add(new pair(tr,tc,dist[tr][tc]));
                }
            }
        }
        int res=dist[grid.length-1][grid[0].length-1];
        return res==Integer.MAX_VALUE?-1:res;
    }
}