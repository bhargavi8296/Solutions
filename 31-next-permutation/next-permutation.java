class Solution {
    public void merge(int nums[],int s, int mid, int e)
    {
        int []t=new int[e-s+1];
        int i=0;
        int j=s;
        int k=mid+1;
        while(j<=mid&&k<=e)
        {
            if(nums[j]<nums[k])
            {
                t[i]=nums[j];++i;++j;
            }
            else{
                t[i]=nums[k];++i;++k;
            }
        }
        while(j<=mid){t[i]=nums[j];++i;++j;}
        while(k<=e){ t[i]=nums[k];++i;++k;}
        k=0;
        for(i=s;i<=e;++i)
        {
            nums[i]=t[k];++k;
        }
    }
    public void sort(int[]nums, int s, int e)
    {
        if(s==e){return;}
        int mid=(s+e)/2;
        sort(nums,s,mid);
        sort(nums,mid+1,e);
        merge(nums,s,mid,e);
    }
    public void nextPermutation(int[] nums) {
        int i=nums.length-2;
        while(i>=0&&nums[i]>=nums[i+1])
        {
            --i;
        }
        if(i<0){sort(nums,0,nums.length-1); return;}
        int j=i+1;
        while(j<nums.length&&nums[i]<nums[j])
        {
            ++j;
        }
        int temp=nums[i];
        nums[i]=nums[j-1];
        nums[j-1]=temp;
        sort(nums,i+1,nums.length-1);
    }
}


