class Solution {
    public int findCircleNum(int[][] isConnected) {
        Queue<Integer>queue=new LinkedList<>();
        int []visited=new int[isConnected.length];
        int sum=0;
        for(int i=0;i<isConnected.length;++i)
        {
            if(visited[i]==0)
            {
                queue.add(i);
                while(!queue.isEmpty())
                {
                    int a=queue.remove();
                    for(int j=0;j<isConnected[a].length;++j)
                    {
                        if(isConnected[a][j]==1&&j!=a&&visited[j]==0)
                        {
                            queue.add(j);
                        }
                    }
                    visited[a]=1;
                }
                ++sum;
            }
        }
        return sum;
    }
}