class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[1] - b[1]);
            int i=0;
            int count=0;
            while(i<intervals.length)
            {
                int j=i+1;
                while(j<intervals.length&&intervals[j][0]<intervals[i][1]){++j;++count;}
                i=j;
            }
            return count;
    }
}
// '1 2
// 1 3
// 2 3
// 3 4'
