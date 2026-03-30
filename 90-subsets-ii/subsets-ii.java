class Solution {
    Set<List<Integer>>set;
    Set<List<Integer>>res;
    public void helper(int[]nums,int ind, List<Integer>temp)
    {
        if(ind<0)
        {
            res.add(temp);
            return;
        }
        List<Integer>list=new ArrayList<>(temp);
        temp.add(nums[ind]);
        if(!set.contains(temp))
        {
            set.add(list);
            helper(nums,ind-1,list);
        }
        helper(nums,ind-1,temp);
    }
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        set=new HashSet<>();
        res=new HashSet<>();
        Arrays.sort(nums);
        helper(nums,nums.length-1,new ArrayList<>());
        List<List<Integer>>list=new ArrayList<>();
        for(List<Integer>t:res)
        {
            list.add(t);
        }
        return list;
    }
}