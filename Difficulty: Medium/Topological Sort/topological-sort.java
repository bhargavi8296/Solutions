class Solution {
    public ArrayList<Integer> topoSort(int V, int[][] edges) {
        // code here
        ArrayList<ArrayList<Integer>>list=new ArrayList<>();
        int in[]=new int[V];
        for(int i=0;i<V;++i){list.add(new ArrayList<>());}
        for(int i=0;i<edges.length;++i)
        {
            int f=edges[i][0];
            int s=edges[i][1];
            list.get(f).add(s);
            in[s]++;
        }
        Queue<Integer>q=new LinkedList<>();
        ArrayList<Integer>res=new ArrayList<>();
        for(int i=0;i<V;++i){if(in[i]==0){q.add(i);}}
        while(!q.isEmpty())
        {
            int temp=q.poll();
            res.add(temp);
            for(int val:list.get(temp))
            {
                in[val]--;
                if(in[val]==0){q.add(val);}
            }
        }
        return res;
    }
}