class Pair implements Comparable<Pair>{
    int row;
    int col;
    int val;
    Pair(int row,int col,int val)
    {
        this.row=row;
        this.col=col;
        this.val=val;
    }
    public int compareTo(Pair pair)
    {
        return this.val>pair.val?1:-1;
    }
}
class Solution {
    public int swimInWater(int[][] grid) {
        int res[][]=new int[grid.length][grid[0].length];
        for(int i=0;i<grid[0].length;++i)
        {
            Arrays.fill(res[i],Integer.MAX_VALUE);
        }
        PriorityQueue<Pair>queue=new PriorityQueue<>();
        res[0][0]=grid[0][0];
        queue.add(new Pair(0,0,res[0][0]));
        while(!queue.isEmpty())
        {
            Pair pair=queue.poll();
            int row=pair.row;
            int col=pair.col;
            int val=pair.val;
            int xx[]={0,0,1,-1};
            int yy[]={1,-1,0,0};
            for(int i=0;i<4;++i)
            {
                int nx=row+xx[i];
                int ny=col+yy[i];
                if(nx>=0&&ny>=0&&nx<grid.length&&ny<grid[0].length)
                {
                    if(res[nx][ny]>res[row][col])
                    {
                        if(grid[nx][ny]>grid[row][col])
                        {
                            res[nx][ny]=Math.max(grid[nx][ny],val);
                            queue.add(new Pair(nx,ny,res[nx][ny]));
                        }
                        else
                        {
                            res[nx][ny]=val;
                           // System.out.print(res[nx][ny]+" "+nx+" "+ny+" ");
                            queue.add(new Pair(nx,ny,res[nx][ny]));
                        }
                    }
                }
            }
            
        }
        
        return res[grid.length-1][grid[0].length-1];
    }
}