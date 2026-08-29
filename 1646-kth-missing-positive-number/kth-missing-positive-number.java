class Solution {
    public int findKthPositive(int[] arr, int k) {
        int l=0;
        int h=arr.length-1;
        int ans=l;
        while(l<=h)
        {
            int mid=(l+h)/2;
            int temp=arr[mid]-mid-1;
            //System.out.println(mid+" "+temp+" "+k);
            if(temp<k){
                ans=mid;
                l=mid+1;
            }
            else{
                h=mid-1;
            }
        }
        //System.out.println(arr[ans]);
        if(arr[ans]-ans>k){
            return arr[ans]-((arr[ans]-ans)-k);
        }
        return arr[ans]+(k-(arr[ans]-ans-1));
    }
}