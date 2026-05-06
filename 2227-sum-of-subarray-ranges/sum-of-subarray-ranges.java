class Solution {
    public long helper(int []nums)
    {
        Stack<Integer>s1=new Stack<>();
        Stack<Integer>s2=new Stack<>();
        Stack<Integer>s3=new Stack<>();
        Stack<Integer>s4=new Stack<>();
        int pre[]=new int[nums.length];
        int post[]=new int[nums.length];
        long pres[]=new long[nums.length];
        long posts[]=new long[nums.length];
        for(int i=0;i<nums.length;++i)
        {
            int n=nums.length-i-1;
            //preStack
            while(!s1.isEmpty()&&nums[s1.peek()]>nums[i]){s1.pop();}
            if(s1.isEmpty()){pre[i]=-1;}
            else{pre[i]=s1.peek();}
            s1.push(i);
            //poststack
            while(!s2.isEmpty()&&nums[s2.peek()]>=nums[n]){s2.pop();}
            if(s2.isEmpty()){post[n]=nums.length;}
            else{post[n]=s2.peek();}
            s2.push(n);
            //preStack
            while(!s3.isEmpty()&&nums[s3.peek()]<nums[i]){s3.pop();}
            if(s3.isEmpty()){pres[i]=-1;}
            else{pres[i]=s3.peek();}
            s3.push(i);
            //poststack
            while(!s4.isEmpty()&&nums[s4.peek()]<=nums[n]){s4.pop();}
            if(s4.isEmpty()){posts[n]=nums.length;}
            else{posts[n]=s4.peek();}
            s4.push(n);
        }
        long result=0;
        for(int i=0;i<nums.length;++i)
        {
            //System.out.print(i);
            long minCount = (long)(i - pre[i]) * (post[i] - i);
            long maxCount = (long)(i - pres[i]) * (posts[i] - i);
            result += (maxCount) * nums[i];
            result -= (minCount) * nums[i];
        }
        return result;

    }
    public long subArrayRanges(int[] nums) {
        return helper(nums);
    }
}