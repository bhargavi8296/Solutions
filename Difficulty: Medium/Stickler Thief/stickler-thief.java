class Solution {
    public int findMaxSum(int arr[]) {
        // code here
        int result[]=new int[arr.length];
        result[result.length-1]=arr[result.length-1];
        if(arr.length>=2)
        {
            result[result.length-2]=Math.max(arr[result.length-2],arr[result.length-1]);
        }
        else{return result[0];}
        for(int i=arr.length-3;i>=0;--i)
        {
            result[i]=Math.max(arr[i]+result[i+2],result[i+1]);
        }
        return Math.max(result[0],result[1]);
        
    }
}