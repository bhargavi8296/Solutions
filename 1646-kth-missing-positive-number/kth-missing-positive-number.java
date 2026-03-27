class Solution {
    public int findKthPositive(int[] arr, int k) {
        int start=1;
        int end=1000001;
        List<Integer> list = new ArrayList<>();
        for(int x : arr){
            list.add(x);
        }
        while(start<=end)
        {
            int mid=(start+end)/2;
            int count=0;
            for(int i=0;i<arr.length;++i)
            {
                if(arr[i]<mid){++count;}
            }
            if(count+k==mid){
                while(list.contains(mid))
                {
                    ++mid;
                }
                return mid;
            }
            else if(count+k>mid){start=mid+1;}
            else{end=mid-1;}
        }
        return -1;
    }
}