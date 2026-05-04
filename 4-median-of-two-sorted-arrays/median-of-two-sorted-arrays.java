class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        boolean flag=(nums1.length+nums2.length)%2==0?true:false;
        int n=((nums1.length+nums2.length)/2)+1;
        int count=0;
        double ele=-1;
        double ele1=-1;
        int i=0;int j=0;
        //System.out.print(n);
        while(i<nums1.length&&j<nums2.length)
        {
            if(count<n)
            {
                if(nums1[i]<=nums2[j])
                {
                    ele1=ele;ele=nums1[i];++i;
                }
                else{
                    ele1=ele;ele=nums2[j];++j;
                }
            }
            else{break;}++count;
        }
        //System.out.print(ele+" "+ele1+" "+count+" "+n+" "+i+" "+j);
        while(count<n&&i<nums1.length)
        {
            ele1=ele;ele=nums1[i];++i;++count;
        }
        while(count<n&&j<nums2.length)
        {
            ele1=ele;ele=nums2[j];++j;++count;
        }
        if(flag){return (ele+ele1)/2;}
        return ele;
    }
}