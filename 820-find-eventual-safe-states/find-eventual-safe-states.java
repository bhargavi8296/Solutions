class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        Queue<Integer>q=new LinkedList<>();
        int []out=new int[graph.length];
        List<List<Integer>>list=new ArrayList<>();
        for(int i=0;i<graph.length;++i)
        {
            out[i]=graph[i].length;
            list.add(new ArrayList<>());
        }
        for(int i=0;i<graph.length;++i)
        {
            if(out[i]==0){q.add(i);}
        }
        for(int i=0;i<graph.length;++i)
        {
            for(int j=0;j<graph[i].length;++j)
            {
                list.get(graph[i][j]).add(i);
            }
        }
        List<Integer>result=new ArrayList<>();
        while(!q.isEmpty())
        {
            int node=q.remove();
            result.add(node);
            for(int val:list.get(node))
            {
                out[val]-=1;
                if(out[val]==0){q.add(val);}
            }
        }
        Collections.sort(result);
        return result;
    }
}