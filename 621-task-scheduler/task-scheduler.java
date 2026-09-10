class pair{
    char ch;
    int num;
    pair(char ch, int num)
    {
        this.ch=ch;
        this.num=num;
    }
}
class Solution {
    public int leastInterval(char[] tasks, int n) {
        PriorityQueue<pair>p1=new PriorityQueue<>((a,b)->b.num-a.num);
        PriorityQueue<pair>p2=new PriorityQueue<>((a,b)->b.num-a.num);
        Set<Character>set=new HashSet<>();
        int arr[]=new int[26];
        for(int i=0;i<tasks.length;++i)
        {
            set.add(tasks[i]);
            arr[tasks[i]-'A']++;
        }
        for(char ch:set)
        {
            //System.out.println(ch+" "+arr[ch-'A']);
            p1.add(new pair(ch,arr[ch-'A']));
        }
        int result=0;
        while(!p1.isEmpty()||!p2.isEmpty())
        {
            int size=p1.isEmpty()?p2.size():p1.size();
            //System.out.println(size);
            if(!p1.isEmpty()){
                int si=n+1;
            while(!p1.isEmpty()&&si>0)
            {
                pair temp=p1.poll();
                temp.num--;
                if(temp.num>0)
                {p2.add(temp);}
                --si;
            }
            while(!p1.isEmpty()){p2.add(p1.poll());}
            }
            else{
                int si=n+1;
            while(!p2.isEmpty()&&si>0)
            {
                pair temp=p2.poll();
                temp.num--;
                if(temp.num>0)
                {p1.add(temp);}--si;
            }
            while(!p2.isEmpty()){p1.add(p2.poll());}
            }
            if(size>=n+1)
            {
                result+=n+1;
            }
            else{result+=(p1.isEmpty()&&p2.isEmpty()?size:n+1);}
        }
        return result;
    }
}