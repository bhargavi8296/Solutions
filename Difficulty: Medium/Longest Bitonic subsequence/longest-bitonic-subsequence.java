class Solution {
    public static int longestBitonicSequence(int n, int[] arr) {
        // code here
        int left[]=new int[n];
        int right[]=new int[n];
        Arrays.fill(left,1);
        Arrays.fill(right,1);
        for(int i=0;i<n;++i)
        {
            for(int j=0;j<i;++j)
            {
                if(arr[i]>arr[j]&&left[j]+1>left[i])
                {
                    left[i]=1+left[j];
                }
            }
        }
        for(int i=n-1;i>=0;--i)
        {
            for(int j=n-1;j>i;--j)
            {
                if(arr[i]>arr[j]&&right[j]+1>right[i])
                {
                    right[i]=1+right[i];
                }
            }
        }
        int max=1;
        for(int i=0;i<n;++i)
        {
            if(right[i]>1&&left[i]>1)
            {max=Math.max(max,left[i]+right[i]);}
        }
        return max-1;
    }
}
