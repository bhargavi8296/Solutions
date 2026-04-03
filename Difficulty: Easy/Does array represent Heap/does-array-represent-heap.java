// User function Template for Java

class Solution {

    public boolean countSub(long arr[], long n) {
        // Your code goes here
        for(int i=0;i<n/2;++i)
        {
            if(i*2+1<n&&arr[i]<arr[i*2+1]){
                return false;
            }
            else if(i*2+2<n&&arr[i]<arr[i*2+2]){
                return false;
            }
        }
        return true;
    }
}