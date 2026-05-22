class Solution {
    ArrayList<Integer>list;
    int visited[];
    public void helper(ArrayList<ArrayList<Integer>> adj,int node)
    {
        for(int val:adj.get(node))
        {
            if(visited[val]==0)
            {
                list.add(val);
                visited[val]=1;
                helper(adj,val);
            }
        }
    }
    public ArrayList<Integer> dfs(ArrayList<ArrayList<Integer>> adj) {
        // code here
        list=new ArrayList<>();
        visited=new int[adj.size()];
        //System.out.print(adj);
        for(int i=0;i<adj.size();++i)
        {
            if(visited[i]==0)
            {
                list.add(i);
                visited[i]=1;
                helper(adj,i);
            }
        }
        return list;
    }
}