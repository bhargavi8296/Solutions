class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int sum=0;
        int start=1;
        for(int i=0;i<weights.length;++i)
        {
            sum+=weights[i];
            start=Math.max(start,weights[i]);
        }
        //Arrays.sort(weights);
        int end=sum;
        int result=end;
        while(start<=end)
        {
            int mid=(start+end)/2;
            int count=1;
            int i=0;
            int top=mid;
           
            while(i<weights.length)
            {
                 //System.out.println(top+" "+weights[i]+" ");
                if(weights[i]<=top)
                {
                    top-=weights[i];
                }
                else{
                    top=mid;
                    top-=weights[i];
                    ++count;
                }
                ++i;
            }
            //System.out.println(count+" "+mid);
            if(count<=days){end=mid-1;result=mid;}
            else{start=mid+1;}
        }
        return result;
    }
}
