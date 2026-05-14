class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> {
            if (a[0] != b[0]) {
                return a[0] - b[0];   
            } else {
                return a[1] - b[1];   
            }});
        int arr[]=new int[intervals.length];
        int m=0;
        Map<Integer,Integer>map=new HashMap<>();
        for(int i=intervals.length-2;i>=0;--i)
        {
            int last=intervals[i][1];
            int max=0;
            if(map.containsKey(last))
            {
                max=map.get(last);
            }
            else{
                for(int j=i+1;j<intervals.length;++j)
                {
                    if(last<=intervals[j][0])
                    {
                        max=Math.max(max,arr[j]+1);
                    }
                }
                map.put(last,max);
            }
            arr[i]=max;
            m=Math.max(m,arr[i]);
        }
        return intervals.length-m-1;
    }
    
}