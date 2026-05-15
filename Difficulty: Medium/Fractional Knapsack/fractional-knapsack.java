class Solution {
    public double fractionalKnapsack(int[] val, int[] wt, int capacity) {
        // code here
        int arr[][]=new int[val.length][2];
        for(int i=0;i<val.length;++i)
        {
            int w=wt[i];
            int v=val[i];
            arr[i][0]=w;
            arr[i][1]=v;
        }
        Arrays.sort(arr,(a,b)->Double.compare((double)b[1] / b[0],
                   (double)a[1] / a[0]));
        double result=0;
        for(int i=0;i<val.length;++i)
        {
            if(capacity<arr[i][0])
            {
                result+=((((double) capacity)/arr[i][0])*arr[i][1]);
                break;
            }
            else{
                result+=arr[i][1];
                capacity-=arr[i][0];
            }
        }
        return result;
    }
}