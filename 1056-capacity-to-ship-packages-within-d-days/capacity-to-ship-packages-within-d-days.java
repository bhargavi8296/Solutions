class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int h=0;
        for(int i=0;i<weights.length;++i)
        {
            h+=weights[i];
        }
        int l=1;
        int ans=Integer.MAX_VALUE;
        while(l<=h)
        {
            int mid=(l+h)/2;
            int s=0;int cnt=1;
            boolean flag=false;
            for(int i=0;i<weights.length;++i)
            {
                if(weights[i]>mid){flag=true;break;}
                if(s+weights[i]>mid)
                {
                    ++cnt;
                    s=0;
                }
                s+=weights[i];
                
            }
            if(flag){l=mid+1;continue;}
            //System.out.println(mid+" "+cnt);
            if(cnt<=days)
            {
                ans=Math.min(ans,mid);
                h=mid-1;
            }
            else{
                l=mid+1;
            }

        }
        return ans;
    }
}