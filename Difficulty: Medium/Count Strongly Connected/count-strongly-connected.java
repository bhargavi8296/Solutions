class Solution {
    // Function to find number of strongly connected components in the graph
    Stack<Integer>st;
    ArrayList<ArrayList<Integer>>list1;
    ArrayList<ArrayList<Integer>>list2;
    int visited[];
    public void dfs1(int node)
    {
        if(visited[node]==1){return ;}
        visited[node]=1;
        for(int val:list1.get(node))
        {
            dfs1(val);
        }
        st.add(node);
    }
    public void dfs2(int node)
    {
        if(visited[node]==1){return ;}
        visited[node]=1;
        for(int val:list2.get(node))
        {
            dfs2(val);
        }
    }
    public int kosaraju(int V, int[][] edges) {
        // code here
        st=new Stack<>();
        visited=new int[V];
        list1=new ArrayList<>();
        list2=new ArrayList<>();
        for(int i=0;i<V;++i)
        {
            list1.add(new ArrayList<>());
            list2.add(new ArrayList<>());
        }
        for(int i=0;i<edges.length;++i)
        {
            int f=edges[i][0];
            int s=edges[i][1];
            list1.get(f).add(s);
            list2.get(s).add(f);
        }
        for(int i=0;i<V;++i)
        {
            if(visited[i]==0)
            {
                dfs1(i);
            }
        }
        Arrays.fill(visited,0);
        int count=0;
        while(!st.isEmpty())
        {
            int temp=st.pop();
            if(visited[temp]==0)
            {
                dfs2(temp);++count;
            }
        }
        return count;
    }
}