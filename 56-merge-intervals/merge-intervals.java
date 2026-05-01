class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> {
    if (a[0] != b[0]) {
        return a[0] - b[0];   // first element
    } else {
        return a[1] - b[1];   // second element
    }});
        List<List<Integer>>result=new ArrayList<>();
        int i=0;
        while(i<intervals.length)
        {
            int j=i+1;
            int second=intervals[i][1];
            while(j<intervals.length&&second>=intervals[j][0])
            {
                second=Math.max(second,intervals[j][1]);++j;
            }
            result.add(new ArrayList<>());
            result.get(result.size()-1).add(intervals[i][0]);
            result.get(result.size()-1).add(second);
            i=j;
        }
        int res[][]=new int[result.size()][2];
        int j=0;
        for(List<Integer>temp:result)
        {
            res[j][0]=temp.get(0);
            res[j][1]=temp.get(1);
            ++j;
        }
        return res;
    }
}