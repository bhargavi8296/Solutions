class Solution {
    int par[];
    int range[];
    public int find(int x)
    {
        if(x==par[x]){return x;}
        return par[x]=find(par[x]);
    }
    public void union(int x, int y)
    {
        if(range[x]>range[y])
        {
            range[x]+=range[y];
            par[y]=x;
        }
        else{
            range[y]+=range[x];
            par[x]=y;
        }
    }
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        Map<String,Integer>map=new HashMap<>();
        int n=accounts.size();
        par=new int[n];
        range=new int[n];
        Arrays.fill(range,1);
        for(int i=0;i<n;++i)
        {
            par[i]=i;
        }
        for(int i=0;i<n;++i)
        {
            int j=0;
            for(String val:accounts.get(i))
            {
                if(j==0){++j;continue;}
                if(map.containsKey(val))
                {
                    int x=i;
                    int y=map.get(val);
                    int px=find(x);
                    int py=find(y);
                    if(px!=py)
                    {
                        union(px,py);
                    }
                }
                else{
                    map.put(val,i);
                }
            }
        }
        //System.out.print(map);
        List<List<String>>result=new ArrayList<>();
        Map<Integer,Set<String>>m1=new HashMap<>();
        for(int i=0;i<n;++i)
        {
            int x=find(i);
            if(!m1.containsKey(x))
            {m1.put(x,new TreeSet());}
            List<String>temp=accounts.get(i);
            for(int j=1;j<temp.size();++j)
            {
                m1.get(x).add(temp.get(j));
            }
        }
        //System.out.println(m1);
        for (Map.Entry<Integer, Set<String>> entry : m1.entrySet()) {
            List<String>t=new ArrayList<>();
            t.add(accounts.get(entry.getKey()).get(0));
            t.addAll(entry.getValue());
            result.add(t);
        }
        return result;
    }
}