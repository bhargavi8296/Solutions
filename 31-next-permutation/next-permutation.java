class Solution {
    public void merge(int[]arr, int i, int mid,int j)
    {
        int temp[]=new int[j-i+1];
        int k=i;
        int l=mid;
        int m=0;
        while(k<mid&&l<=j)
        {
            if(arr[k]<=arr[l])
            {
                temp[m]=arr[k];++k;
            }
            else{
                temp[m]=arr[l];++l;
            }
            ++m;
        }
        while(k<mid){temp[m]=arr[k];++k;++m;}
        while(l<=j){temp[m]=arr[l];++l;++m;}k=0;
        for(int t=i;t<=j;++t)
        {
            //System.out.println(arr[t]+" "+temp[k]);
            arr[t]=temp[k];++k;

        }
    }
    public void sort(int[]nums, int i, int j)
    {
        if(i>=j){return;}
        int mid=(i+j)/2;
        sort(nums,i,mid);
        sort(nums,mid+1,j);
        merge(nums,i,mid+1,j);
    }
    public void nextPermutation(int[] arr) {
        boolean flag=false;
        for(int i=arr.length-2;i>=0;--i)
        {
            if(arr[i]<arr[i+1])
            {
                for(int j=arr.length-1;j>i;--j)
                {
                    if(arr[j]>arr[i])
                    {
                        int temp=arr[j];
                        arr[j]=arr[i];
                        arr[i]=temp;
                        sort(arr,i+1,arr.length-1);
                        flag=true; break;
                    }
                }
                        break;
            } 
        }
        if(!flag){sort(arr,0,arr.length-1);}
    }
}