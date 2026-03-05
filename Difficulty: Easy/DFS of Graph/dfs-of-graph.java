class Solution {
    ArrayList<Integer>list;
    int visited[];
    public void helper(ArrayList<ArrayList<Integer>> adj,int i)
    {
        if(visited[i]==1){return;}
        
        list.add(i);
        visited[i]=1;
        for(int val:adj.get(i))
        {
            if(visited[val]==0)
            {
                helper(adj,val);   
            }
        }
    }
    public ArrayList<Integer> dfs(ArrayList<ArrayList<Integer>> adj) {
        // code here
        list=new ArrayList<>();
        visited=new int[adj.size()];
        for(int i=0;i<adj.size();++i)
        {
            if(visited[i]==0)
            {
                //System.out.println(i);
                helper(adj,i);
            }
        }
        return list;
    }
}