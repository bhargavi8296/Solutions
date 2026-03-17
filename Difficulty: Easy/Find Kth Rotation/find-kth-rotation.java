class Solution {
    public int findKRotation(int arr[]) {
        // Code here
        int start=0;
        int end=arr.length-1;
        while(start<end)
        {
            int mid=(start+end)/2;
            if(arr[start]>arr[mid])
            {
                end=mid;
            }
            else if(arr[mid]>arr[end]){
                start=mid+1;
            }
            else{break;}
        }
        return start;
    }
}