class Solution {
    int countFreq(int[] arr, int target) {
        // code here
        int count=0;
        int start=0;
        int end=arr.length-1;
        int m=-1;
        while(start<=end)
        {
            int mid=(start+end)/2;
            if(arr[mid]==target){m=mid;break;}
            else if (arr[mid]>target){end=mid-1;}
            else
            {
                start=mid+1;
            }
        }
        if(m==-1){return 0;}
        int i=m-1;
        int j=m;
        while(i>=0)
        {
            if(arr[i]==target){--i;++count;}
            else{break;}
        }
        while(j<arr.length)
        {
            if(arr[j]==target){++j;++count;}
            else{break;}
        }
        return count;
    }
}
