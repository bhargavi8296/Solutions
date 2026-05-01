class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>>list=new ArrayList<>();
        for(int i=0;i<nums.length-3;++i)
        {
            for(int j=i+1;j<nums.length-2;++j)
            {
                int k=j+1;int l=nums.length-1;
                long sum=nums[i]+nums[j];
                while(k<l)
                {
                    long s=sum+nums[k]+nums[l];
                    if(s>target){--l;}
                    else if(s<target){++k;}
                    else{
                        List<Integer>temp=new ArrayList<>();
                        temp.add(nums[i]);temp.add(nums[j]);temp.add(nums[k]);temp.add(nums[l]);
                        if(!list.contains(temp)){list.add(temp);} ++k;--l;
                        //break;
                    }
                }
                
            }
        }
        return list;
    }
}