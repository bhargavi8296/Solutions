class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>>result=new ArrayList<>();
        Arrays.sort(nums);
        for(int i=0;i<nums.length-3;++i){
            if(i>0&&nums[i]==nums[i-1]){continue;}
            for(int j=i+1;j<nums.length-2;++j)
            {
                if(j>i+1&&nums[j]==nums[j-1]){continue;}
                int l=j+1;
                int r=nums.length-1;
                while(l<r)
                {
                    long sum=(long)nums[i]+nums[j]+nums[l]+nums[r];
                    //System.out.print(sum);
                    if(sum>Integer.MAX_VALUE||sum<Integer.MIN_VALUE){break;}
                    if(sum==target)
                    {
                        List<Integer>temp=new ArrayList<>();
                        temp.add(nums[i]);
                        temp.add(nums[j]);
                        temp.add(nums[l]);
                        temp.add(nums[r]);
                        result.add(temp);
                        ++l;
                        --r;
                        while(l<r&&nums[l-1]==nums[l]){++l;}
                        while(l<r&&nums[r]==nums[r+1]){--r;}
                    }
                    else if(sum<target){++l;}
                    else{--r;}
                }
            }
        }
        return result;
    }
}