class Solution {
    public void reverseArray(int arr[]) {
        // code here
        int n=arr.length/2;
        int i=0;
        int j=arr.length-1;
        while(n>0)
        {
            int temp=arr[i];
            arr[i]=arr[j];
            arr[j]=temp;
            ++i;--j;--n;
        }
    }
}