class Solution {
    public int noOfCows(int[] stalls, int mid)
    {
        int i=0;
        int n=0;
        for(int j=1;j<stalls.length;++j)
        {
            if(stalls[j]-stalls[i]>=mid){++n;i=j;}
            
        }
        return n+1;
    }
    public int aggressiveCows(int[] stalls, int k) {
        // code here
        int start=1;
        Arrays.sort(stalls);
        int end=stalls[stalls.length-1]-stalls[0];
        int result=1;
        while(start<=end)
        {
            int mid=(start+end)/2;
            
            int temp=noOfCows(stalls,mid);
            //System.out.println(mid+" "+end+" "+temp);
            if(temp>=k){result=Math.max(result,mid);start=mid+1;}
            else if(temp<k){end=mid-1;}
        }
        return result;
    }
}