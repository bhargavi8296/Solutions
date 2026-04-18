class pair{
    int f; int s;
    pair(int f, int s)
    {
        this.f=f;
        this.s=s;
    }
}
class Solution {
    public int minPlatform(int arr[], int dep[]) {
        //  code here
        Queue<pair>q= new PriorityQueue<>((a,b)->{if(a.f==b.f){return b.s-a.s;}return a.f-b.f;});
        for(int i=0;i<arr.length;++i)
        {
            q.add(new pair(arr[i],1));
        }
        for(int i=0;i<dep.length;++i)
        {
            q.add(new pair(dep[i],-1));
        }
        int platform=0;
        int maxPlatform=0;
        while(!q.isEmpty())
        {
            pair p=q.poll();
            platform+=p.s;
            maxPlatform=Math.max(maxPlatform,platform);
            
        }
        return maxPlatform;
    }
}
