class pair{
    int f;
    int s;
    pair(int f, int s)
    {
        this.f=f;
        this.s=s;
    }
}
class Solution {
    // Function to find the maximum number of meetings that can
    // be performed in a meeting room.
    public int maxMeetings(int start[], int end[]) {
        // add your code here
        Queue<pair>q=new PriorityQueue<>((a,b)->{
           return a.s-b.s;
        });
        
        int n=start.length;
        for(int i=0;i<n;++i)
        {
            q.add(new pair(start[i],end[i]));
        }
        int count=0;
        int last=-1;
        while(!q.isEmpty())
        {
            pair p=q.poll();
            if(p.f>last)
            {
                ++count;
                last=p.s;
            }
        }
        return count;
    }
}
