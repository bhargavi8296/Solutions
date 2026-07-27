class Solution {
    int visited[];
    int colour[];
    public boolean helper(int[][]graph, int i)
    {
        for(int val:graph[i])
        {
            if(visited[val]==1)
            {
                if(colour[val]==colour[i]){return true;}
                continue;
            }
            else{
                colour[val]=colour[i]==0?1:0;
                visited[val]=1;
                if(helper(graph,val)){return true;}
            }
        }
        return false;
    }
    public boolean isBipartite(int[][] graph) {
        visited=new int[graph.length];
        colour=new int[graph.length];
        Arrays.fill(colour,-1);
        for(int i=0;i<graph.length;++i)
        {
            if(visited[i]==0)
            {
                visited[i]=1;
                colour[i]=0;
                if(helper(graph,i)){return false;}
            }
        }
        return true;

    }

}