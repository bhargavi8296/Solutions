class Solution {
    public int arrangeCoins(int n) {
        int low=0;
        int high=n;   
        int result=1;
        while(low<=high)
        {
            int mid = low + (high - low) / 2;
            long temp = (long) mid * (mid + 1) / 2;
            long num=mid>65535?Long.MAX_VALUE:temp;
            //System.out.println(mid+" "+num+" "+temp);
            if(num<=(long)n){
                result=mid;
                low=mid+1;
            }
            else{
                high=mid-1;
            }
        }
        return result;
    }
}