class Solution {
    Set<List<Integer>>set;
    Set<List<Integer>>res;
    public void helper(int[]candidates,int target,int i,List<Integer>temp)
    {
        //System.out.print(temp);
        if(target==0){Collections.reverse(temp);set.add(new ArrayList<>(temp));return;}
        if(i<0||target<0){return;}
        if(target>=candidates[i])
        {
            List<Integer>t=new ArrayList<>();
            t.addAll(temp);
            t.add(candidates[i]);
            if(!res.contains(t))
            {
                res.add(t);
                helper(candidates,target-candidates[i],i-1,t);
            }
        }
         helper(candidates,target,i-1,temp);
    }
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        set=new HashSet<>();
        res=new HashSet<>();
        helper(candidates,target, candidates.length-1,new ArrayList<>());
        List<List<Integer>>list=new ArrayList<>();
        for(List<Integer>t:set)
        {
            list.add(t);
        }
        return list;
    }
}