class Solution {
    public int minBitFlips(int start, int goal) {
        int dif=start^goal;
        int count=0;
        while(dif>0)
        {
            //System.out.print(dif+" ");
            start=start|(dif&(~(dif-1)));
            dif=dif&(dif-1);
            //System.out.print(dif+" ");
            ++count;
        }
        return count;
    }
}