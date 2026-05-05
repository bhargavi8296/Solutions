class Solution {
    public boolean isPerfectSquare(int num) {
        int low=0;
        int high=num;
        while(low<=high)
        {
            int mid=(low+high)/2;
            
            if((long)mid*mid==(long)num){return true;}
            else if((long)mid*mid<(long)num){low=mid+1;}
            else{high=mid-1;}
        }
        return false;
    }
}