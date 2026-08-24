class Solution {
    public List<List<Integer>> generate(int numRows) {
        int i=1;
        List<List<Integer>>list=new ArrayList<>();
        list.add(new ArrayList<>());
        list.get(list.size()-1).add(1);
        while(i<numRows)
        {
            List<Integer>temp=new ArrayList<>();
            for(int j=0;j<=i;++j)
            {
                if(j==0||j==i){temp.add(1);}
                else{
                    temp.add(list.get(list.size()-1).get(j-1)+list.get(list.size()-1).get(j));
                }
            }++i;
            list.add(temp);
        }
        return list;
    }
}