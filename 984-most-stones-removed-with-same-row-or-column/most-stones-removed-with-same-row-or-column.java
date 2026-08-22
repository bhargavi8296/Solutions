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
            par[y]=par[x];
        }
        else{
            range[y]+=range[x];
            par[x]=par[y];
        }
    }
    public int removeStones(int[][] stones) {
        int max=0;
        int r=0;
        int c=0;
        for(int i=0;i<stones.length;++i){
            r=Math.max(r,stones[i][0]+1);
            c=Math.max(c,stones[i][1]+1);
        }
        par=new int[r+c];
        range=new int[r+c];
        Arrays.fill(range,1);
        for(int i=0;i<r+c;++i)
        {
            par[i]=i;
        }
        for(int i=0;i<stones.length;++i)
        {
            int x=stones[i][0];
            int y=r+stones[i][1];
            int px=find(x);
            int py=find(y);
            if(px!=py)
            {
                union(px,py);
            }
            
        }
        int connected=0;
        for(int i=0;i<par.length;++i)
        {
            //System.out.println(i+" "+par[i]);
            if(i==par[i]&&range[i]>1){++connected;}
        }
        //System.out.print(connected);
        return stones.length-connected;

    }
}