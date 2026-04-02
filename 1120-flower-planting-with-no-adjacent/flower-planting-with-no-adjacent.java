class Solution {
    List<List<Integer>>list;
    int visited[];
    int result[];
    public void helper(int j)
    {
        for(int val:list.get(j))
        {
            if(visited[val]==0)
            {
                int temp[]=new int[visited.length];
                for(int t:list.get(val))
                {
                    if(visited[t]!=0&&t!=val)
                    {
                        temp[result[t]-1]=1;}
                }
                visited[val]=1;
                for(int i=0;i<temp.length;++i)
                {
                    if(temp[i]==0)
                    {
                        result[val]=i+1;
                        helper(val);break;
                    }
                }
            }
        }
    }
    public int[] gardenNoAdj(int n, int[][] paths) {
        list=new ArrayList<>();
        visited=new int[n];
        result=new int[n];
        for(int i=0;i<n;++i){list.add(new ArrayList<>());}
        for(int i=0;i<paths.length;++i)
        {
            int f=paths[i][0]-1;
            int s=paths[i][1]-1;
            list.get(f).add(s);
            list.get(s).add(f);
        }
        for(int i=0;i<n;++i)
        {
            if(visited[i]==0)
            {
                result[i]=1;
                visited[i]=1;
                helper(i);
            }
        }
        return result;
    }
}