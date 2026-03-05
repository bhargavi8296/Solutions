class Solution {
    int color[];
    int visited[];
    public boolean helper(int[][]graph,int i)
    {
        for(int val:graph[i])
        {
            if(visited[val]==0){visited[val]=1;color[val]=color[i]==0?1:0;if(!helper(graph,val)){return false;}}
            else{if(color[i]==color[val]){return false;}}
        }
        return true;
    }
    public boolean isBipartite(int[][] graph) {
        color=new int[graph.length];
        visited=new int[graph.length];
        Arrays.fill(color,-1);
        for(int i=0;i<graph.length;++i)
        {
            if(color[i]==-1)
            {
                color[i]=0;
                visited[i]=1;
                if(!helper(graph,i)){return false;}
            }
        }
        return true;
    }
}