class Solution {
    public long subArrayRanges(int[] nums) {
        int left[]=new int[nums.length];
        int right[]=new int[nums.length];
        Stack<Integer>l=new Stack<>();
        Stack<Integer>r=new Stack<>();
        for(int i=0;i<nums.length;++i)
        {
            while(!l.isEmpty()&&nums[i]<=nums[l.peek()])
            {
                l.pop();
            }
            if(l.isEmpty())
            {
                left[i]=-1;
            }
            else{
                left[i]=l.peek();
            }
            l.push(i);
            while(!r.isEmpty()&&nums[nums.length-i-1]<nums[r.peek()]){r.pop();}
            if(r.isEmpty()){
                right[nums.length-i-1]=nums.length;
            }
            else{
                right[nums.length-i-1]=r.peek();
            }
            r.push(nums.length-i-1);
        }
        int left1[]=new int[nums.length];
        int right1[]=new int[nums.length];
        l.clear();
        r.clear();
        for(int i=0;i<nums.length;++i)
        {
            while(!l.isEmpty()&&nums[i]>=nums[l.peek()])
            {
                l.pop();
            }
            if(l.isEmpty())
            {
                left1[i]=-1;
            }
            else{
                left1[i]=l.peek();
            }
            l.push(i);
            while(!r.isEmpty()&&nums[nums.length-i-1]>nums[r.peek()]){r.pop();}
            if(r.isEmpty()){
                right1[nums.length-i-1]=nums.length;
            }
            else{
                right1[nums.length-i-1]=r.peek();
            }
            r.push(nums.length-i-1);
        }
        long sum=0;
        for(int i=0;i<nums.length;++i)
        {
            sum += (long)(i - left1[i]) * (right1[i] - i) * nums[i];
            sum -= (long)(i - left[i]) * (right[i] - i) * nums[i];
        }
        return sum;
    }
}
