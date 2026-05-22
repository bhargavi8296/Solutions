class Solution {
    int visited[];
    ArrayList<ArrayList<Integer>>list;
    public boolean helper(int node, int parent)
    {
        if(visited[node]==1){return true;}
        visited[node]=1;
        for(int val:list.get(node))
        {
            if(val!=parent)
            {
                if(helper(val,node)){return true;}
            }
        }
        return false;
    }
    public boolean isCycle(int V, int[][] edges) {
        // Code here
        visited=new int[V];
        list=new ArrayList<>();
        for(int i=0;i<V;++i)
        {
            list.add(new ArrayList<>());
        }
        for(int i=0;i<edges.length;++i)
        {
            int f=edges[i][0];
            int s=edges[i][1];
            list.get(f).add(s);
            list.get(s).add(f);
        }
        for(int i=0;i<V;++i)
        {
            if(visited[i]==0)
            {
                if(helper(i,-1)){return true;}
            }
        }
        return false;
        
    }
}