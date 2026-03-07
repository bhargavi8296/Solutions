class pair{
    int r;
    int c;
    pair(int r,int c)
    {
        this.r=r;
        this.c=c;
    }
}
class Solution {
    public int minimumEffortPath(int[][] heights) {
        int dist[][]=new int[heights.length][heights[0].length];
        for(int i=0;i<heights.length;++i)
        {
            Arrays.fill(dist[i],Integer.MAX_VALUE);
        }
        Queue<pair>q=new LinkedList<>();
        q.add(new pair(0,0));
        dist[0][0]=0;
        while(!q.isEmpty())
        {
            pair p=q.poll();
            int r=p.r;
            int c=p.c;
            int ro[]={0,1,0,-1};
            int co[]={1,0,-1,0};
            for(int i=0;i<4;++i)
            {
                int tr=r+ro[i];
                int tc=c+co[i];
                if(tr>=0&&tr<heights.length&&tc>=0&&tc<heights[0].length&&dist[tr][tc]>Math.max(dist[r][c],Math.abs(heights[tr][tc]-heights[r][c])))
                {
                    dist[tr][tc]=Math.max(dist[r][c],Math.abs(heights[tr][tc]-heights[r][c]));
                    q.add(new pair(tr,tc));
                }
            }
        }
        return dist[heights.length-1][heights[0].length-1];
    }
}