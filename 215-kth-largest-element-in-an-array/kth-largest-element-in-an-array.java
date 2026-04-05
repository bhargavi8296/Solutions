class Solution {
    public void helper(int start, int []arr, int size)
    {
        int smallest=start;
        int left=2*start+1;
        int right=2*start+2;
        if(left<=size&&arr[start]<arr[left])
        {
            smallest=left;
        }
        if(right<=size&&arr[smallest]<arr[right])
        {
            smallest=right;
        }
        if(smallest!=start)
        {
            int i=arr[start];
            arr[start]=arr[smallest];
            arr[smallest]=i;
            helper(smallest,arr,size);
        }
    }
    public int findKthLargest(int[] arr, int k) {
        for(int i=1;i<arr.length;++i)
        {
            int temp=i;
            while(temp>0)
            {
                int par=(temp-1)/2;
                if(arr[par]<arr[temp])
                {
                    int t=arr[par];
                    arr[par]=arr[temp];
                    arr[temp]=t;
                }
                else{
                    break;
                }
                temp=(temp-1)/2;
            }
        }
        int size=arr.length-1;
        for(int i=0;i<k-1;++i)
        {
            int t=arr[0];
            arr[0]=arr[size];
            arr[size]=t;
            --size;
            helper(0,arr,size);
        }
        return arr[0];
    }
}