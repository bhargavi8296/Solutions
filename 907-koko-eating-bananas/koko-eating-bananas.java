class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int start=1;
        int max=Integer.MIN_VALUE;
        for(int i=0;i<piles.length;++i)
        {
            max=Math.max(max,piles[i]);
        }
        int result=max;
        //System.out.print(start+" "+max);
            while(start<max)
            {
                int mid=(start+max)/2;
                //System.out.println(mid+" ");
                int count=0;
                for(int i=0;i<piles.length;++i)
                {
                    if(piles[i]<=mid)
                    {
                        count+=1;
                    }
                    else
                    { 
                        if(piles[i]%mid==0){count+=(piles[i]/mid);}
                        else{count+=((piles[i]/mid)+1);}
                    }
                }
                //System.out.println(mid+" "+count+" "+start+" "+max);
                if(count<=h){result=mid;max=mid;}
                else if(count>h){start=mid+1;}
            }
        return result;
    }
}
