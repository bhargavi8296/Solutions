// User function Template for Java

class Solution {
    public static void helper(int start, int arr[],int size)
    {
        int smallest=start;
        if(2*start+1<=size&&arr[2*start+1]>arr[start])
        {
          smallest=2*start+1;  
        }
        if(2*start+2<=size&&arr[2*start+2]>arr[smallest])
        {
            smallest=2*start+2;
        }
        if(smallest!=start)
        {
            int temp=arr[start];
            arr[start]=arr[smallest];
            arr[smallest]=temp;
            helper(smallest,arr,size);
        }
        
    }
    static void convertMinToMaxHeap(int N, int arr[]) {
        // code here
        int size=arr.length;
        for(int i=(size/2)-1;i>=0;--i)
        {
            helper(i,arr,size-1);
        }
    }
}
