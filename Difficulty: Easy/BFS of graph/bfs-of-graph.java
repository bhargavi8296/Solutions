class Solution {
    public ArrayList<Integer> bfs(ArrayList<ArrayList<Integer>> adj) {
        // code here
        ArrayList<Integer>list=new ArrayList<>();
        int visited[]=new int[adj.size()];
        Queue<Integer>q=new LinkedList<>();
        for(int i=0;i<adj.size();++i)
        {
            if(visited[i]==0)
            {
                q.add(i);
                visited[i]=1;
                while(!q.isEmpty())
                {
                    int temp=q.poll();
                    list.add(temp);
                    for(int val:adj.get(temp))
                    {
                        if(visited[val]==0)
                        {
                            q.add(val);
                            visited[val]=1;
                        }
                    }
                }   
            }
        }
        return list;
    }
}