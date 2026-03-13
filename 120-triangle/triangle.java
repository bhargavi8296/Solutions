class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        for(int i=1;i<triangle.size();++i)
        {
            for(int j=0;j<triangle.get(i).size();++j)
            {
                int fist=j-1>=0?triangle.get(i-1).get(j-1):Integer.MAX_VALUE;
                int sec=j<triangle.get(i-1).size()?triangle.get(i-1).get(j):Integer.MAX_VALUE;
                //System.out.println(fist+" "+sec+" "+triangle.get(i).get(j));
                triangle.get(i).set(j,triangle.get(i).get(j)+Math.min(fist,sec));
            }
        }
        int min=Integer.MAX_VALUE;
        //System.out.print(triangle);
        for(int val:triangle.get(triangle.size()-1))
        {
            min=Math.min(min,val);
        }
        return min;
    }
}