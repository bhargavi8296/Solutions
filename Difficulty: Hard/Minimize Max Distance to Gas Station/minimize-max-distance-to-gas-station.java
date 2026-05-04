class pair{
    int i;
    double d;
    pair(int i, double d)
    {
        this.i=i;
        this.d=d;
    }
}
class Solution {
    public double minMaxDist(int[] stations, int k) {
        // code here
        if(stations.length==1){return 0;}
        PriorityQueue<pair> q = new PriorityQueue<>((a, b) -> Double.compare(b.d, a.d));

        int n=stations.length;
        int s[]=new int[stations.length-1];
        Arrays.fill(s,1);
        for(int i=0;i<n-1;++i)
        {
            double dist=stations[i+1]-stations[i];
            q.add(new pair(i,dist));
        }
        //System.out.print(q);
        while(k>0)
        {
            pair p=q.poll();
            int ind=p.i;
            double d=(p.d)*s[ind];
            double dist=(d)/(s[ind]+1);
            //System.out.println(dist+" "+ind);
            //int d=s[ind]+1;
            s[ind]++;
            q.add(new pair(ind,dist));--k;
        }
       double max=-1;
       for(int i=0;i<=n-2;++i)
        {
            double dist=stations[i+1]-stations[i];
            //System.out.println(dist+" "+s[i]+" "+i);
            max=Math.max(max,dist/(s[i]));
        }
       return max;
    }
}
