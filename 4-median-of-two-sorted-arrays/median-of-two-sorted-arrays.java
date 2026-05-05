class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if(nums1.length>nums2.length)
        {
            int temp[]=nums1;
            nums1=nums2;
            nums2=temp;            
        }
        int n1=nums1.length;
        int n2=nums2.length;
        int low=0;int high=n1;
        while(low<=high)
        {
            //int mid=(low+high)/2;
            int r1=(low+high)/2;
            int r2=((n1+n2+1)/2)-r1;
            int l1=r1-1;
            int l2=r2-1;
            int l1n=l1<0?Integer.MIN_VALUE:nums1[l1];
            int l2n=l2<0?Integer.MIN_VALUE:nums2[l2];
            int r1n=r1>=n1?Integer.MAX_VALUE:nums1[r1];
            int r2n=r2>=n2?Integer.MAX_VALUE:nums2[r2];
            if(l1n<=r2n&&l2n<=r1n){
                if((n1+n2)%2==0){return (Math.max(l1n,l2n)+Math.min(r1n,r2n))/2.0;}
                return Math.max(l1n,l2n);}
            else if(l1n>r2n){high=r1-1;}
            else{low=r1+1;}
        }
        return 0.0;
    }
}