/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        int low=0;
        int high=n;
        while(low<=high)
        {
            long mid=((long)low+(long)high)/2;
            if(isBadVersion((int)mid))
            {
                high=(int)mid-1;
            }
            else{
                low=(int)mid+1;
            }
        }
        return low;
    }
}