class Solution {
    int par[];
    int rank[];
    public int find(int x)
    {
        if(x==par[x]){return x;}
        return par[x]=find(par[x]);
    }
    public void union(int x, int y)
    {
        if(rank[x]>rank[y])
        {
            par[y]=x;
            rank[x]+=rank[y];
        }
        else
        {
            par[x]=y;
            rank[y]+=rank[x];
        }
    }
    public int removeStones(int[][] stones) {
        int x=0;
        int y=0;
        for(int i=0;i<stones.length;++i){x=Math.max(x,stones[i][0]);y=Math.max(y,stones[i][1]);}
        par=new int[x+y+2];
        rank=new int[x+y+2];
        Arrays.fill(rank,1);
        Set<Integer>set=new HashSet<>();
        for(int i=0;i<par.length;++i)
        {
            par[i]=i;
        }
        for(int i=0;i<stones.length;++i)
        {
            int r=stones[i][0];
            int c=x+1+stones[i][1];set.add(r);set.add(c);
            int pr=find(r);
            int pc=find(c);
            if(pr!=pc){
                union(pr,pc);
            }
        }
        int count=0;
        for(int i=0;i<par.length;++i)
        {
            if(i==par[i]&&set.contains(i)){++count;}
        }
        return stones.length-count;
    }
}