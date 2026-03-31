class Solution {
    List<List<Integer>>list;
    Set<List<Integer>>set;
    public void helper(int k, int n, List<Integer>temp,int i)
    {
        if(n==0&&k==0){list.add(temp);}
        if(i<1||k==0||n==0){return;}
        if(i<=n){
            List<Integer>t=new ArrayList<>();
            t.addAll(temp);
            t.add(i);
            if(!set.contains(t))
            {set.add(t);helper(k-1,n-i,t,i-1);}
            }
            helper(k,n,temp,i-1);
    }
    public List<List<Integer>> combinationSum3(int k, int n) {
        if(n>55){return new ArrayList<>();}
        list=new ArrayList<>();
        set=new HashSet<>();
        helper(k,n,new ArrayList<>(),9);
        return list;
    }
}