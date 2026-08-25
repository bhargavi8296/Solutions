class Solution {
    public int[][] merge(int[][] nums) {
        Arrays.sort(nums, (a, b) -> {
            if (a[0] != b[0]) {
                return a[0] - b[0];   
            } else {
                return a[1] - b[1];   
            }});
            int i=0;
            List<List<Integer>>list=new ArrayList<>();
            while(i<nums.length)
            {
                int j=i+1;

                while(j<nums.length&&nums[j-1][0]<=nums[j][0]&&nums[j-1][1]>=nums[j][0])
                {
                    nums[j][1]=Math.max(nums[j][1],nums[j-1][1]);
                    ++j;
                }
                List<Integer>temp=new ArrayList<>();
                temp.add(nums[i][0]);
                temp.add(nums[j-1][1]);
                list.add(temp);
                i=j;
                
            }
            int result[][]=new int[list.size()][2];
            for( i=0;i<list.size();++i)
            {
                result[i][0]=list.get(i).get(0);
                result[i][1]=list.get(i).get(1);
            }
            return result;
    }
}