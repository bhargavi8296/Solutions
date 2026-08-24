class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer>result=new ArrayList<>();
        int r=0;
        int re=matrix.length-1;
        int c=0;
        int ce=matrix[0].length-1;
        while(r<=re||c<=ce)
        {
            if(r<=re)
            {
                for(int i=c;i<=ce;++i)
                {
                    result.add(matrix[r][i]);
                }
            }
            ++r;
            if(c<=ce)
            {
                for(int i=r;i<=re;++i)
                {
                    result.add(matrix[i][ce]);
                }
            }
            --ce;
            if(r<=re)
            {
                for(int i=ce;i>=c;--i)
                {
                    result.add(matrix[re][i]);
                }
            }
            --re;
            if(c<=ce)
            {
                for(int i=re;i>=r;--i)
                {
                    result.add(matrix[i][c]);
                }
            }
            ++c;

        }
        return result;
    }
}