class Solution {
    public ArrayList<Integer> topoSort(int V, int[][] edges) {
        // code here
        ArrayList<Integer>result=new ArrayList<>();
        int in[]=new int[V];
        ArrayList<ArrayList<Integer>>list=new ArrayList<>();
        for(int i=0;i<V;++i)
        {
            list.add(new ArrayList<>());
        }
        for(int i=0;i<edges.length;++i)
        {
            int f=edges[i][0];
            int s=edges[i][1];
            in[s]++;
            list.get(f).add(s);
        }
        Queue<Integer>q=new LinkedList<>();
        for(int i=0;i<V;++i)
        {
            if(in[i]==0)
            {
                q.add(i);
                result.add(i);
            }
        }
        while(!q.isEmpty())
        {
            int node=q.poll();
            for(int val:list.get(node))
            {
                in[val]--;
                if(in[val]==0)
                {
                    q.add(val);
                    result.add(val);
                }
            }
        }
        return result;
    }
}