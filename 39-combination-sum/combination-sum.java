class Solution {
    List<List<Integer>>list;
    public void helper(int[] candidates, int target,int i,List<Integer>temp)
    {
        if(target<0||i<0){return;}
        if(target==0){list.add(new ArrayList<>(temp));return;}
        if(candidates[i]<=target){List<Integer>t=new ArrayList<>();t.addAll(temp);t.add(candidates[i]);helper(candidates,target-candidates[i],i,t);}
        helper(candidates,target,i-1,temp);
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        list=new ArrayList<>();
        helper(candidates,target,candidates.length-1,new ArrayList<>());
        return list;
    }
}