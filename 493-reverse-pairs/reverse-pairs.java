class Solution {
    int count=0;
    public void merge(int[]nums, int start, int mid, int end){
        int i=start;
        int j=mid;
        int k=0;
        int temp[]=new int[end-start+1];
        while(i<mid&&j<=end)
        {
            if(nums[i]<nums[j])
            {
                temp[k]=nums[i];++i;
            }
            else{
                temp[k]=nums[j];++j;
            }
            ++k;
        }
        while(i<mid){
            temp[k]=nums[i];++i;++k;
        }
        while(j<=end)
        {
            temp[k]=nums[j];++j;++k;
        } k=0;
        for(int m=start;m<=end;++m)
        {
            //System.out.println(temp[k]);
            nums[m]=temp[k];++k;
        }
    }
    public void mergeSort(int[]nums, int start, int end)
    {
        if(start>=end){return;}
        int mid=(start+end)/2;
        int i=start;
        int j=mid+1;
        mergeSort(nums,start,mid);
        mergeSort(nums,mid+1,end);
        while(i<mid+1)
        {
            while(j<=end&&nums[i]>2L*nums[j])
            {
                ++j;
            }
            count+=(j-mid-1);
            ++i;
        }
        merge(nums,start,mid+1,end);
    }
    public int reversePairs(int[] nums) {
        mergeSort(nums,0,nums.length-1);
        return count;
    }
}