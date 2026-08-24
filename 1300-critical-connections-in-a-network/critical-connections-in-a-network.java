class Solution {
    List<List<Integer>>result;
    List<List<Integer>>list;
    int time[];
    int least[];
    int visited[];
    int counter;
    public void helper(int node, int par){
        least[node]=counter;
        time[node]=counter;
        visited[node]=1;
        ++counter;
        for(int val:list.get(node))
        {
            if(val==par){continue;}
            if(visited[val]==1)
            {
                least[node]=Math.min(least[node],time[val]);
            }
            else{
                helper(val,node);
                least[node] = Math.min(least[node], least[val]);

                // Bridge condition
                if (least[val] > time[node]) {
                    result.add(new ArrayList<>());
                    result.get(result.size() - 1).add(node);
                    result.get(result.size() - 1).add(val);
                }
            }
        }
    }
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        list=new ArrayList<>();
        result=new ArrayList<>();
        visited=new int[n];
        time=new int[n];
        least=new int[n];
        counter=0;
        for(int i=0;i<n;++i)
        {
            list.add(new ArrayList<>());
        }
        for(int i=0;i<connections.size();++i)
        {
            int f=connections.get(i).get(0);
            int s=connections.get(i).get(1);
            list.get(f).add(s);
            list.get(s).add(f);
        }
        helper(0,-1);
        return result;
    }
}