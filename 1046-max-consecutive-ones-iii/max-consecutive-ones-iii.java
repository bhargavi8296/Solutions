class Solution {
    public int longestOnes(int[] nums, int k) {
        Queue<Integer>q=new LinkedList<>();
        int result=0;
        int count=0;
        for(int i=0;i<nums.length;++i)
        {
            //System.out.print(q);
            if(nums[i]==0){if(k>0){--k;++count;q.add(i);}else if(!q.isEmpty()){int temp=q.poll();count=i-temp;q.add(i);}else{count=0;}}
            else{++count;}
            result=Math.max(result,count);
        }
        return result;
    }
}