class Solution {
    public ArrayList<Integer> spirallyTraverse(int[][] mat) {
        // code here
        int rs=0;
        int rl=mat.length-1;
        int cs=0;
        int cl=mat[0].length-1;
        ArrayList<Integer>list=new ArrayList<>();
        while(rs<=rl||cs<=cl)
        {
            if(rs<=rl)
            {
                for(int i=cs;i<=cl;++i)
                {
                    list.add(mat[rs][i]);
                }
                ++rs;
            }
            if(cl>=cs)
            {
                for(int i=rs;i<=rl;++i)
                {
                    list.add(mat[i][cl]);
                }
                --cl;
            }
            if(rl>=rs)
            {
                for(int i=cl;i>=cs;--i)
                {
                    list.add(mat[rl][i]);
                }
                --rl;
            }
            if(cs<=cl)
            {
                for(int i=rl;i>=rs;--i)
                {
                    list.add(mat[i][cs]);
                }
                ++cs;
            }
        }
        return list;
    }
}
