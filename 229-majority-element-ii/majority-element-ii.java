class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int count1=0;
        int count2=0;
        int candidate1=0;
        int candidate2=0;
        for(int i=0;i<nums.length;++i)
        {
            if(nums[i]==candidate1){++count1;}
            else if(nums[i]==candidate2){++count2;}
            else if(count1==0){candidate1=nums[i];++count1;}
            else if(count2==0){candidate2=nums[i];++count2;}
            else{--count1;--count2;}
        }
        //System.out.println(count1+" "+count2+" "+candidate1+" "+candidate2);
        List<Integer>result=new ArrayList<>();
        int c1=0;
        int c2=0;
        for(int i=0;i<nums.length;++i)
        {
            if(nums[i]==candidate1){++c1;}
            else if(nums[i]==candidate2){++c2;}
        }
        if(c1>nums.length/3){result.add(candidate1);}
        if(c2>nums.length/3){result.add(candidate2);}
        return result;

    }
}