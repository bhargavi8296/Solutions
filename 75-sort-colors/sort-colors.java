class Solution {
    public void sortColors(int[] nums) {
        int i=0;
        int j=0;
        while(i<nums.length)
        {
            while(i<nums.length&&nums[i]==0){++i;}
            j=i+1;
            while(j<nums.length&&nums[j]!=0){++j;}
            if(j<nums.length)
            {
                int temp=nums[i];
                nums[i]=nums[j];
                nums[j]=temp;
            }
            else{
                break;
            }
            ++i;
        }
        while(i<nums.length)
        {
            while(i<nums.length&&nums[i]==1){++i;}
            j=i+1;
            while(j<nums.length&&nums[j]!=1){++j;}
            if(j<nums.length)
            {
                int temp=nums[i];
                nums[i]=nums[j];
                nums[j]=temp;
            }
            else{
                break;
            }
            ++i;
        }
    }
}