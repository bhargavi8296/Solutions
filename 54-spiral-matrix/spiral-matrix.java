class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int c=0;int ce=matrix[0].length-1;int r=0;int re=matrix.length-1;
        List<Integer>list=new ArrayList<>();
        while(r<=re&&c<=ce)
        {
            for(int i=c;i<=ce;++i)
            {
                list.add(matrix[r][i]);
            }
            ++r;
            for(int i=r;i<=re;++i)
            {
                list.add(matrix[i][ce]);
            }
            --ce;
            if(r<=re){
            for(int i=ce;i>=c;--i)
            {
                list.add(matrix[re][i]);
            }
            --re;}
            if(c<=ce){
            for(int i=re;i>=r;--i)
            {
                list.add(matrix[i][c]);
            }
            ++c;}
        }
        return list;
    }
}