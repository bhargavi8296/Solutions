class Solution {
    int visited[];
    int pvisited[];
    public boolean helper(int V, ArrayList<ArrayList<Integer>>list)
    {
        if(visited[V]==1){return true;}
        if(pvisited[V]==1){return false;}
        //System.out.print(V+" ");
        visited[V]=1;
        pvisited[V]=1;
        for(int val:list.get(V))
        {
            if(helper(val,list)){return true;}
        }
        visited[V]=0;
        return false;
    }
    public boolean isCyclic(int V, int[][] edges) {
        // code here
        ArrayList<ArrayList<Integer>>list=new ArrayList<>();
        visited=new int[V];
        pvisited=new int[V];
        for(int i=0;i<V;++i)
        {
            list.add(new ArrayList<>());
        }
        for(int i=0;i<edges.length;++i)
        {
            int f=edges[i][0];
            int s=edges[i][1];
            list.get(f).add(s);
        }
        for(int i=0;i<V;++i)
        {
            if(pvisited[i]==0)
            {
                if(helper(i,list)){return true;}
            }
        }
        return false;
    }
}