class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        int hash[]=new int[nums.length];
        int dp[]=new int[nums.length];
        Arrays.fill(dp,1);
        Arrays.sort(nums);
        int max=0;
        int ind=0;
        for(int i=0;i<nums.length;++i)
        {
            hash[i]=i;
            for(int j=0;j<i;++j)
            {
                //System.out.println(i+" "+j+" "+(nums.length-1));
                if(nums[i]%nums[j]==0&&dp[i]<dp[j]+1)
                {
                    dp[i]=dp[j]+1;
                    //System.out.println(i+" "+dp[i]+" ");
                    if(max<dp[i]){max=dp[i];ind=i;}
                    hash[i]=j;
                }
            }
        }
        List<Integer>list=new ArrayList<>();
        while(ind!=hash[ind])
        {
            list.add(nums[ind]);
            ind=hash[ind];
        }
        list.add(nums[ind]);
        Collections.reverse(list);
        return list;
    }
}
