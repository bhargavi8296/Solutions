class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        if((m*k)>bloomDay.length){return -1;}
        int l=Integer.MAX_VALUE;
        int h=Integer.MIN_VALUE;
        for(int i=0;i<bloomDay.length;++i)
        {
            l=Math.min(l,bloomDay[i]);
            h=Math.max(h,bloomDay[i]);
        }
        int ans=-1;
        while(l<=h)
        {
            int mid=(l+h)/2;
            int time=0;
            int count=0;
            for(int i=0;i<bloomDay.length;++i)
            {
                if(bloomDay[i]<=mid)
                {
                    ++count;
                }
                else{
                    time+=(count/k);
                    count=0;
                }
            }
            time+=(count/k);
            //System.out.println(time+" "+mid);
            if(time>=m){
                ans=mid;
                h=mid-1;
            }
            else{
                l=mid+1;
            }
        }
        return ans;
    }
}