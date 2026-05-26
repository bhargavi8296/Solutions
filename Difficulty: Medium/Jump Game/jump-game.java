// User function Template for Java

class Solution {
    // Function to check if we can reach the last index from the 0th index.
    public boolean canReach(int[] arr) {
        // code here
        boolean []result=new boolean[arr.length];
        result[arr.length-1]=true;
        for(int i=arr.length-2;i>=0;--i)
        {
            for(int j=i;j<arr.length&&j<=i+arr[i];++j)
            {
                if(result[j]==true)
                {
                    result[i]=true;
                    break;
                }
            }
        }
        return result[0];
    }
}