class Solution {
    public int noOfPeople(int[]arr,int k)
    {
        int sum=0;
        int n=0;
        for(int val:arr)
        {
            //System.out.println(sum+" "+k);
            
            if(sum>=val){sum-=val;}
            else{sum=k-val;++n;}
            //System.out.print(n+" ");
        }
        return n;
    }
    public int findPages(int[] arr, int k) {
        // code here
        if(k>arr.length){return -1;}
        int start=1;
        int end=0;
        for(int val:arr)
        {
            start=Math.max(start,val);
            end+=val;
        }
        int result=Integer.MAX_VALUE;
        while(start<=end)
        {
            int mid=(start+end)/2;
            
            int n=noOfPeople(arr,mid);
            //System.out.println(" ");
            if(n<=k){result=Math.min(result,mid);end=mid-1;}
            else if(n>k){start=mid+1;}
            //else{end=mid-1;}
        }
        return result==Integer.MAX_VALUE?-1:result;
    }
}