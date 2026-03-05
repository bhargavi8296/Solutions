class pair{
    int p;
    int c;
    pair(int p,int c)
    {
        this.p=p;
        this.c=c;
    }
}
class Solution {
    public boolean isCycle(int V, int[][] edges) {
        // Code here
        ArrayList<ArrayList<Integer>>list=new ArrayList<>();
        Queue<pair>q=new LinkedList<>();
        for(int i=0;i<V;++i){list.add(new ArrayList<>());}
        for(int i=0;i<edges.length;++i)
        {
            int f=edges[i][0];
            int s=edges[i][1];
            list.get(f).add(s);list.get(s).add(f);
        }
        int visited[]=new int[V];
        for(int i=0;i<V;++i)
        {
            if(visited[i]==0)
            {
                q.add(new pair(-1,i));
                while(!q.isEmpty())
                {
                    pair t=q.poll();
                    
                    visited[t.c]=1;
                    for(int val:list.get(t.c))
                    {
                        //System.out.println(val+" "+visited[val]+""+t.p);
                        if(visited[val]==0)
                        {
                            q.add(new pair(t.c,val));
                        }
                        else if(val!=t.p)
                        {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }
}