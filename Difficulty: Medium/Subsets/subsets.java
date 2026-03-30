class Solution {
    ArrayList<ArrayList<Integer>>list;
    public void helper(int arr[],int ind,List<Integer>temp)
    {
        if(ind<0){list.add(new ArrayList<>(temp));return;}
        List<Integer>t=new ArrayList<>();
        t.addAll(temp);
        t.add(arr[ind]);
        helper(arr,ind-1,t);
        helper(arr,ind-1,temp);
        
    }
    public ArrayList<ArrayList<Integer>> subsets(int arr[]) {
        // code here
        list=new ArrayList<>();
        helper(arr,arr.length-1,new ArrayList<>());
        return list;
    }
}