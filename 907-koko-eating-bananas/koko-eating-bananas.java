class Solution {
    public int minEatingSpeed(int[] piles, int ho) {
        int h=0;
        for(int i=0;i<piles.length;++i)
        {
            h=Math.max(h,piles[i]);
        }
        int l=1;
        int ans=h;
        while(l<h)
        {
            int mid=(l+h)/2;
            int sum=0;
            for(int i=0;i<piles.length;++i)
            {
                if(piles[i]%mid!=0)
                {sum+=1;}
                sum+=(piles[i]/mid);
            }
            //System.out.println(mid+" "+sum);
            if(sum<=ho)
            {
                ans=Math.min(ans,mid);
                h=mid;
            }
            else{l=mid+1;}
        }
        return ans;
    }
}
