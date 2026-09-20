class Solution {
    int color[];
    public boolean helper(int[][]graph,int i)
    {
        //System.out.println(i);
        for(int val:graph[i])
        {
            if(color[val]!=-1)
            {
                if(color[val]==color[i]){return false;}
                continue;
            }
            color[val]=color[i]==1?0:1;
            if(!helper(graph,val)){return false;}
        }
        return true;
    }
    public boolean isBipartite(int[][] graph) {
        color=new int[graph.length];
        Arrays.fill(color,-1);
        for(int i=0;i<graph.length;++i)
        {
            if(color[i]==-1){color[i]=0;if(!helper(graph,i)){return false;}}
        }
        return true;
    }
}