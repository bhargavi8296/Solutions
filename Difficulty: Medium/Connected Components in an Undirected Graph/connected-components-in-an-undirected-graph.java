class Solution {
    ArrayList<ArrayList<Integer>>result;
    ArrayList<ArrayList<Integer>>list;
    int visited[];
    public void helper(int i,ArrayList<Integer>temp)
    {
        if(visited[i]==1){return;}
        temp.add(i);
        visited[i]=1;
        for(int val:list.get(i))
        {
            //System.out.println(val);
            if(visited[val]==0)
            {
                helper(val,temp);
            }
        }
    }
    public ArrayList<ArrayList<Integer>> getComponents(int V, int[][] edges) {
        // code here
        result=new ArrayList<>();
        list=new ArrayList<>();
        visited=new int[V];
        for(int i=0;i<V;++i)
        {
            list.add(new ArrayList<>());
        }
        for(int i=0;i<edges.length;++i)
        {
            int f=edges[i][0];
            int s=edges[i][1];
            list.get(f).add(s);list.get(s).add(f);
        }
        //System.out.print(list);
        for(int i=0;i<V;++i)
        {
            //System.out.println(visited[i]+" "+i+" .");
            if(visited[i]==0)
            {
                ArrayList<Integer>temp=new ArrayList<>();
                helper(i,temp);
                result.add(temp);
            }
        }
        return result;
    }
}