class Solution {
    public int nthRoot(int n, int m) {
        // code here
        if(m==0||m==1){return m;}
        int start=1;
        int end=m/n;
        double t=m;
        while(start<=end)
        {
            int mid=(start+end)/2;
            double res=(double)Math.pow(mid,n);
            if(res==t){return mid;}
            else if(res>t){end=mid-1;}
            else{start=mid+1;}
        }
        return -1;
    }
}