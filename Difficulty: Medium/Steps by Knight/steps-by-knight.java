class pair{
    int row;
    int col;
    int dist;
    pair(int r, int c, int d)
    {
        row=r;
        col=c;
        dist=d;
    }
}
class Solution {
    int matrix[][];
    
    public int minStepToReachTarget(int knightPos[], int targetPos[], int n) {
        // Code here
        matrix=new int[n][n];
        for(int i=0;i<n;++i)
        {
            Arrays.fill(matrix[i],Integer.MAX_VALUE);
        }
        matrix[knightPos[0]-1][knightPos[1]-1]=0;
        Queue<pair>q=new PriorityQueue<>((a,b)->a.dist-b.dist);
        q.add(new pair(knightPos[0]-1,knightPos[1]-1,0));
        int r[]={1,1,-1,-1,2,-2,2,-2};
        int c[]={2,-2,2,-2,1,1,-1,-1};
        while(!q.isEmpty())
        {
            pair p=q.poll();
            int row=p.row;
            int col=p.col;
            if(row==targetPos[0]-1&&col==targetPos[1]-1)
            {
                return p.dist;
            }
            for(int i=0;i<8;++i)
            {
                int tr=row+r[i];
                int tc=col+c[i];
                //System.out.println(tr+" "+tc);
                if(tr>=0&&tr<n&&tc>=0&&tc<n&&matrix[tr][tc]>matrix[row][col]+1)
                {
                    matrix[tr][tc]=matrix[row][col]+1;
                    q.add(new pair(tr,tc,matrix[tr][tc]));
                }
            }
        }
        return -1;
        
    }
}