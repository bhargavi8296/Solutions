class Solution {
    public int findMin(int[] arr) {
        int start=0;
        int end=arr.length-1;
        int min=Integer.MAX_VALUE;
        while(start<=end)
        {
            int mid=(start+end)/2;
            if(arr[start]<=arr[mid]&&arr[mid]<=arr[end]){min=Math.min(min, arr[start]);break;}
            if(arr[start]>arr[mid]){
                min=Math.min(arr[mid],min);
                end=mid-1;
            }
            else{
                start=mid+1;
            }
        }
        return min;
    }
}