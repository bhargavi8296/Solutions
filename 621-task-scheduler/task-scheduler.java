class pair{
    char ch;
    int c;
    pair(char ch,int c)
    {
        this.ch=ch;
        this.c=c;
    }
}
class Solution {
    public int leastInterval(char[] tasks, int n) {
        Queue<pair>q=new PriorityQueue<>((a,b)->b.c-a.c);
        int []val=new int[26];
        for(int i=0;i<tasks.length;++i)
        {
            //System.out.print(tasks[i]-'a');
            val[(int)(tasks[i]-'A')]++;
        }
        for(int i=0;i<=25;++i)
        {
            if(val[i]>0){q.add(new pair((char)('A'+i),val[i]));}
        }
        int count=0;
        while(!q.isEmpty())
        {
            int size=Math.min(n+1,q.size());
            int temp=size;
            count+=(n+1);
            Queue<pair>q1=new PriorityQueue<>((a,b)->b.c-a.c);
            while(size>0)
            {
                pair top=q.poll();
                char ch=top.ch;
                int v=top.c;
                if(v>1)
                {
                    q1.add(new pair(ch,v-1));
                }
                --size;
            }
            q.addAll(q1);
            if(q.isEmpty())
            {count-=(n+1-temp);}
        }
        return count;
    }
}