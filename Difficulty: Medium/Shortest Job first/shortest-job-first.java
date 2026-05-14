class Solution {
    static int solve(int bt[]) {
        // code here
        Arrays.sort(bt);
        int re=0;
        int ans=0;
        for(int i=0;i<bt.length-1;++i)
        {
            re+=bt[i];
            ans+=re;
            //System.out.print(ans+" ");
        }
        return ans/bt.length;
    }
}

