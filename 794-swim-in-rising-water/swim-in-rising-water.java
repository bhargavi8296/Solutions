class pair{
    int r;
    int c;
    int t; 
    pair(int r, int c, int t)
    {
        this.r=r;
        this.c=c;
        this.t=t;
    }
}
class Solution {
    public int swimInWater(int[][] grid) {
        Queue<pair>q=new PriorityQueue<>((a,b)->{return a.t-b.t;});
        q.add(new pair(0,0,grid[0][0]));
        int n=grid.length;
        int vis[][]=new int[n][n];
        for(int i=0;i<n;++i)
        {
            Arrays.fill(vis[i],Integer.MAX_VALUE);
        }
        vis[0][0]=grid[0][0];
        while(!q.isEmpty()){
            pair temp=q.poll();
            int r= temp.r;
            int c=temp.c;
            int t=temp.t;
            //System.out.println(r+" "+c+"."+t);
            if(r==n-1&&c==n-1){return t;}
            int ro[]={0,1,0,-1};
            int co[]={1,0,-1,0};
            for(int i=0;i<4;++i)
            {
                int tr=r+ro[i];int tc=c+co[i];
                //System.out.println(tr+" "+tc+" "+grid[tr][tc]+" "+grid[r][c]);
                if(tr>=0&&tr<n&&tc>=0&&tc<n)
                {
                    //System.out.println(tr+" "+tc);
                    if(grid[tr][tc]<grid[r][c]&&vis[tr][tc]>t){q.add(new pair(tr,tc,t));grid[tr][tc]=t;}
                    else if(grid[tr][tc]>grid[r][c]&&vis[tr][tc]>t+grid[tr][tc]-grid[r][c]){q.add(new pair(tr,tc,t+grid[tr][tc]-grid[r][c]));grid[tr][tc]=t+grid[tr][tc]-grid[r][c];}
                }
            }
        }
        return -1;
    }
}