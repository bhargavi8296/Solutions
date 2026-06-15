class Solution {
    public int findContentChildren(int[] g, int[] s) {
        int count=0;
        int i=0;
        int j=0;
        Arrays.sort(g);
        Arrays.sort(s);
        while(i<g.length&&j<s.length)
        {
            while(j<s.length&&g[i]>s[j])
            {
                ++j;
            }
            if(j<s.length){++count;++i;++j;}
        }
        return count;
    }
}