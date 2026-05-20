class Solution {
    public int celebrity(int mat[][]) {
        // code here
        int ko[]=new int[mat.length];
        int kt[]=new int[mat.length];
        for(int i=0;i<mat.length;++i)
        {
            for(int j=0;j<mat[i].length;++j)
            {
                if(i!=j&&mat[i][j]==1)
                {
                    ko[i]++;
                    kt[j]++;
                }
            }
        }
        int ind=-1;
        for(int i=0;i<mat.length;++i)
        {
            if(ko[i]==0&&kt[i]==mat.length-1){return i;}
        }
        return ind;
    }
}
