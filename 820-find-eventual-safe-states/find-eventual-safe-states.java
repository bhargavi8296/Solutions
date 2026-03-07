class Solution {
    List<List<Integer>>list;
    List<Integer>result;
    int in[];
    int visited[];
    public void helper(int i)
    {
        if(visited[i]==1){return;}
        visited[i]=1;
        result.add(i);
        for(int val:list.get(i))
        {
                in[val]--;
                if(in[val]==0&&visited[val]==0)
                {
                helper(val);
                }
            
        }
    }
    public List<Integer> eventualSafeNodes(int[][] graph) {
        list=new ArrayList<>();
        result=new ArrayList<>();
        in=new int[graph.length];
        visited=new int[graph.length];
        for(int i=0;i<graph.length;++i){list.add(new ArrayList<>());}
        for(int i=0;i<graph.length;++i)
        {
            for(int val:graph[i])
            {
                in[i]++;
                list.get(val).add(i);
            }
        }
        for(int i=0;i<graph.length;++i)
        {
            if(in[i]==0&&visited[i]==0)
            {
                helper(i);
            }
        }
        Collections.sort(result);
        return result;
    }
}