class Solution {
    boolean visited[];
    List<List<Integer>>list;
    public void helper(int node)
    {
        for(int val:list.get(node))
        {
            if(!visited[val])
            {
                visited[val]=true;
                helper(val);
            }
        }
    }
    public int findCircleNum(int[][] isConnected) {
        list=new ArrayList<>();
        int ver=isConnected.length;
        visited=new boolean[ver];
        int res=0;
        for(int i=0;i<isConnected.length;++i)
        {
            list.add(new ArrayList());
            for(int j=0;j<isConnected[i].length;++j)
            {
                if(isConnected[i][j]==1)
                {
                    if(i!=j){list.get(i).add(j);}
                }
            }
        }
        for(int i=0;i<ver;++i)
        {
            if(!visited[i])
            {
                visited[i]=true;
                helper(i);
                ++res;
            }
        }
        return res;
    }
}