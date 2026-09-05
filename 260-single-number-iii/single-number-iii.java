class Solution {
    public int[] singleNumber(int[] nums) {
        int xor=0;
        for(int i=0;i<nums.length;++i)
        {
            xor=xor^nums[i];
        }
        int temp=(xor^((xor)&(xor-1)));
        //System.out.println((xor)^(xor-1));
        int zero=0;
        int one=0;
        for(int i=0;i<nums.length;++i)
        {
            if((temp&nums[i])==0)
            {
                zero^=nums[i];
            }
            else{
                one^=nums[i];
            }
        }
        int result[]=new int[2];
        result[0]=zero;
        result[1]=one;
        return result;
    }
}