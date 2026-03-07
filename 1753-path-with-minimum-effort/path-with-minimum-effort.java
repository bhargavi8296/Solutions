class Solution {
    public int minimumEffortPath(int[][] heights) {
        int dist[][]=new int[heights.length][heights[0].length];
        for(int i=0;i<heights.length;++i)
        {
            Arrays.fill(dist[i],Integer.MAX_VALUE);
        }
        Queue<int[]>q=new LinkedList<>();
        q.add(new int[]{0,0});
        dist[0][0]=0;
        while(!q.isEmpty())
        {
            int p[]=q.poll();
            int r=p[0]; 
            int c=p[1];
            int ro[]={0,1,0,-1};
            int co[]={1,0,-1,0};
            for(int i=0;i<4;++i)
            {
                int tr=r+ro[i];
                int tc=c+co[i];
                if(tr>=0&&tr<heights.length&&tc>=0&&tc<heights[0].length)
                {
                    int res=Math.max(dist[r][c],Math.abs(heights[tr][tc]-heights[r][c]));
                    if(dist[tr][tc]>res)
                    {
                        dist[tr][tc]=res;
                        q.add(new int[]{tr,tc});
                    }
                }
            }
        }
        return dist[heights.length-1][heights[0].length-1];
    }
}