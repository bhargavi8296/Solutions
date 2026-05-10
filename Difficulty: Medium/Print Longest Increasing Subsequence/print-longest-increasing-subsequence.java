class Solution {
    public ArrayList<Integer> getLIS(int arr[]) {
        // Code here
        int hash[]=new int[arr.length];
        int max=0;
        int ind=0;
        int dp[]=new int[arr.length];
        Arrays.fill(dp,1);
        for(int i=0;i<arr.length;++i)
        {
            hash[i]=i;
            for(int j=0;j<i;++j)
            {
                if(arr[j]<arr[i]&&dp[j]+1>dp[i])
                {
                    dp[i]=dp[j]+1;
                    if(max<dp[i])
                    {max=dp[i];ind=i;}
                    hash[i]=j;
                }
            }
        }
        ArrayList<Integer>list=new ArrayList<>();
        while(ind!=hash[ind])
        {
            list.add(arr[ind]);
            ind=hash[ind];
        }
        list.add(arr[ind]);
        Collections.reverse(list);
        return list;
    }
}
