class Solution {
    public int maxWater(int arr[]) {
        // code here
        Stack<Integer>s1=new Stack<>();
        int sum=0;
        int left[]=new int[arr.length];
        int right[]=new int[arr.length];
        int max=arr[0];
        for(int i=1;i<arr.length;++i)
        {
            if(max<arr[i])
            {
                max=arr[i];
            }
            else{
            left[i]=max;}
        }
        max=arr[arr.length-1];
        for(int i=arr.length-2;i>=0;--i)
        {
            if(max<arr[i])
            {
                max=arr[i];
            }
            else{
            right[i]=max;
            }
            //System.out.println(right[i]);
        }
        for(int i=0;i<arr.length;++i)
        {
            int res=Math.min(left[i],right[i]);
            sum+=(res>arr[i]?res-arr[i]:0);
        }
        return sum;
    }
}
