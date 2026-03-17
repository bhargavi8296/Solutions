class Solution {
    int floorSqrt(int n) {
        // code here
        if(n==1){return 1;}
        int start=1;
        int end=(n)/2;
        while(start<=end)
        {
            int mid=(start+end)/2;
            //System.out.print(mid+" "+n+" ");
            if((mid*mid)==n){return mid;}
            else if((mid*mid)>n){end=mid-1;}
            else{
                start=mid+1;
            }
        }
        return end;
    }
}