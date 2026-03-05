class Solution {
    List<List<Integer>>list;
    int[]visited;
    public void helper(int i)
    {
        if(visited[i]==1){return;}
        visited[i]=1;
        for(int val:list.get(i))
        {
            helper(val);
        }
    }
    public int findCircleNum(int[][] isConnected) {
        list=new ArrayList<>();
        visited=new int[isConnected.length];
        for(int i=0;i<isConnected.length;++i){list.add(new ArrayList<>());}
        for(int i=0;i<isConnected.length;++i)
        {
            for(int j=0;j<isConnected[0].length;++j)
            {
                if(i!=0&&isConnected[i][j]==1)
                {
                    list.get(i).add(j);list.get(j).add(i);
                }
            }
        }
        int count=0;
        for(int i=0;i<isConnected.length;++i)
        {
            if(visited[i]==0)
            {
                ++count;
                helper(i);
            }
        }
        return count;
    }
}