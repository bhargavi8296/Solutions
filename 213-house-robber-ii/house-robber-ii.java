class Solution {
    public int rob(int[] nums) {
        if(nums.length==1){return nums[0];}
        int arr[]=new int[nums.length-1];
        for(int i=arr.length-1;i>=0;--i)
        {
            arr[i]=nums[i];
            if(i+2<arr.length){arr[i]=nums[i]+arr[i+2];}
            if(i+1<arr.length){arr[i]=Math.max(arr[i],arr[i+1]);}
        }
        int max=arr[0];
        for(int i=arr.length-1;i>=0;--i)
        {
            arr[i]=nums[i+1];
            if(i+2<arr.length){arr[i]=nums[i+1]+arr[i+2];}
            if(i+1<arr.length){arr[i]=Math.max(arr[i],arr[i+1]);}
        }
        //System.out.print(arr[0]+" "+max);
        max=Math.max(max,arr[0]);
        return max;
    }
}
