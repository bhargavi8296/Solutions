class pair{
    int val;
    int ind;
    pair(int val, int ind)
    {
        this.val=val;
        this.ind=ind;
    }
}
class Solution {
    public int candy(int[] ratings) {
        Queue<pair>q=new PriorityQueue<>((a,b)->a.val-b.val);
        int temp[]=new int[ratings.length];
        for(int i=0;i<ratings.length;++i)
        {q.add(new pair(ratings[i],i));}
        while(!q.isEmpty())
        {
            pair p=q.poll();
            int val=p.val;
            int ind=p.ind;
            int left=ind-1<0?val:ratings[ind-1];
            int lv=ind-1<0?0:temp[ind-1];
            int right=ind+1>=ratings.length?val:ratings[ind+1];
            int rv=ind+1>ratings.length-1?0:temp[ind+1];
            int result=0;
            if(val>left){result=Math.max(result,lv);}
            if(val>right){result=Math.max(result,rv);}
            result+=1;
            temp[ind]=result;
        }
        int result=0;
        for(int val:temp)
        {
            result+=val;
        }
        return result;
    }
}