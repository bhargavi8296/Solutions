class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int l[]=new int[nums.length];
        int r[]=new int[nums.length];
        Stack<Integer>st=new Stack<>();
        for(int i=0;i<nums.length;++i)
        {
            while(!st.isEmpty()&&nums[st.peek()]<=nums[i])
            {
                st.pop();
            }
            if(st.isEmpty())
            {
                l[i]=-1;
            }
            else{
                l[i]=st.peek();
            }
            st.push(i);
        }
        st.clear();
        for(int i=nums.length-1;i>=0;--i)
        {
            while(!st.isEmpty()&&nums[st.peek()]<nums[i])
            {
                st.pop();
            }
            if(st.isEmpty())
            {
                r[i]=nums.length;
            }
            else{
                r[i]=st.peek();
            }
            st.push(i);
        }
        int w=0;
        int result[]=new int[nums.length-k+1];
        for(int i=0;i<nums.length;++i)
        {
            int left=Math.min(k,i-l[i]);
            int right=Math.min(k,r[i]-i);
            int total=left+right-1;
            //System.out.println(total+" "+nums[i]+" "+left+" "+right+" "+l[i]+" "+r[i]);
            if(total>=k)
            {
                result[w]=nums[i];
                ++w;
                for(int j=0;j<total-k;++j)
                {
                    result[w]=nums[i];
                    ++w;
                }
            }
        }
        return result;
    }
}