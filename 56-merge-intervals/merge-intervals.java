class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> {
            if (a[0] != b[0]) {
                return a[0] - b[0];   
            } else {
                return a[1] - b[1];   
            }});
            List<List<Integer>>list=new ArrayList<>();
            int i=0;
            while(i<intervals.length)
            {
                int last=intervals[i][1];
                int j=i+1;
                while(j<intervals.length&&last>=intervals[j][0])
                {
                    last=Math.max(last,intervals[j][1]);
                    ++j;
                }
                List<Integer>temp=new ArrayList<>();
                temp.add(intervals[i][0]);
                temp.add(last);
                list.add(temp);
                i=j;
            }
            int result[][]=new int[list.size()][2];
            i=0;
            for(List<Integer>temp:list)
            {
                result[i][0]=temp.get(0);
                result[i][1]=temp.get(1);++i;
            }
            return result;
    }
}