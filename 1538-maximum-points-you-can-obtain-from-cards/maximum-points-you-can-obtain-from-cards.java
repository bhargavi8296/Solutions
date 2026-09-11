class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int lsum=0;
        int max=0;
        for(int i=0;i<k;++i)
        {
            lsum+=cardPoints[i];
        }
        max=lsum;
        for(int i=0;i<k;++i)
        {
            lsum-=cardPoints[k-i-1];
            lsum+=cardPoints[cardPoints.length-1-i];
            max=Math.max(max,lsum);
        }
        return max;
    }
}
// 6 8 3 12