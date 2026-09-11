class Solution {
    public int countCommas(int n) {
        int count=0;
        for(int i=1000;i<=n;++i)
        {
            int temp=i;
            while(temp>=1000)
            {
                ++count;
                temp=temp/1000;
            }
        }
        return count;
    }
}