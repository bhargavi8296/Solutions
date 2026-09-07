class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int nums[][]=new int[intervals.length+1][2];
        for(int i=0;i<intervals.length;++i)
        {
            nums[i][0]=intervals[i][0];
            nums[i][1]=intervals[i][1];
        }
        nums[intervals.length][0]=newInterval[0];
        nums[intervals.length][1]=newInterval[1];
        Arrays.sort(nums, (a, b) -> {
            if (a[0] != b[0]) {
                return a[0] - b[0];   
            } else {
                return a[1] - b[1];   
            }});
            List<List<Integer>>temp=new ArrayList<>();
            int i=0;
            //System.out.println(nums.length);
            while(i<nums.length)
            {
                int j=i+1;
                while(j<nums.length&&nums[j-1][0]<=nums[j][0]&&nums[j-1][1]>=nums[j][0])
                {
                    //System.out.println(nums[j][0]+" "+nums[j][1]);
                    nums[j][1]=Math.max(nums[j][1],nums[j-1][1]);++j;
                }
                List<Integer>t=new ArrayList<>();
                t.add(nums[i][0]);
                t.add(nums[j-1][1]);
                temp.add(t);
                i=j;
            }
            int result[][]=new int[temp.size()][2];
            for(i=0;i<temp.size();++i)
            {
                result[i][0]=temp.get(i).get(0);
                result[i][1]=temp.get(i).get(1);
            }
            return result;
    }
}