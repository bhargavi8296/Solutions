class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        if((m*k)>bloomDay.length){return -1;}
        int min=Integer.MAX_VALUE;
        int max=Integer.MIN_VALUE;
        for(int i=0;i<bloomDay.length;++i)
        {
            min=Math.min(min,bloomDay[i]);
            max=Math.max(max,bloomDay[i]);
        }
        int result=-1;
        while(min<=max)
        {
            int mid=(min+max)/2;
            //System.out.println(mid+" ");
            int i=0;
            int res=0;
            while(i<bloomDay.length)
            {
                int count=0;
                while(i<bloomDay.length&&bloomDay[i]<=mid)
                {
                    ++count;++i;
                }
                res+=(count/k);++i;
            }
            if(res>=m){result=mid;max=mid-1;}
            else{min=mid+1;}
        }
        return result;
    }
}