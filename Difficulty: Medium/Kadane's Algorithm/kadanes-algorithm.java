class Solution {
    int maxSubarraySum(int[] arr) {
        // Code here
        int sum=0;
        int max=arr[0];
        for(int i=0;i<arr.length;++i)
        {
            if(sum+arr[i]>=arr[i])
            {
                sum+=arr[i];
            }
            else{
                sum=arr[i];
            }
            max=Math.max(max, sum);
        }
        return max;
    }
}
