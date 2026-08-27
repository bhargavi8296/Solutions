class Solution {
    public int findPeakElement(int[] nums) {
        int []arr=new int[nums.length+2];
        arr[0]=Integer.MIN_VALUE;
        arr[arr.length-1]=Integer.MIN_VALUE;
        int l=1;
        int h=arr.length-2;
        for(int i=0;i<nums.length;++i)
        {
            arr[i+1]=nums[i];
        }
        //System.out.println(l+" "+h);
        while(l<h)
        {
            int mid=(l+h)/2;
            //System.out.println(mid+" "+arr[mid]);
            if(arr[mid]>arr[mid+1]&&arr[mid]>arr[mid-1]){return mid-1;}
            else if(arr[mid]>arr[mid+1]){h=mid-1;}
            else{l=mid+1;}
        }
        return l-1;
    }
}