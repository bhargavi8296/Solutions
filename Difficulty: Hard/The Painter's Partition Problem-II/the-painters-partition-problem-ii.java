class Solution {
    public int helper(int[]arr, int mid)
    {
        int n=0;
        int sum=0;
        for(int val:arr)
        {
            if(sum>=val){sum-=val;}
            else{sum=mid-val;++n;}
        }
        return n;
    }
    public int minTime(int[] arr, int k) {
        // code here
        int start=1;
        int end=0;
        for(int val:arr)
        {
            start=Math.max(start,val);
            end+=val;
        }
        int result=end;
        while(start<=end)
        {
            int mid=(start+end)/2;
            //System.out.print(mid+" ");
            int n=helper(arr,mid);
            if(n<=k){result=Math.min(result,mid);end=mid-1;}
            else{start=mid+1;}
        }
        return result;
    }
}
