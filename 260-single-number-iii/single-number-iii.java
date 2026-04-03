class Solution {
    public int[] singleNumber(int[] nums) {
        int xor=0;
        for(int i=0;i<nums.length;++i)
        {
            xor^=nums[i];
        }
        int bit=(xor)&(~(xor-1));
        int f=0;
        int s=0;
        for(int i=0;i<nums.length;++i)
        {
            if((nums[i]&bit)==0){f^=nums[i];}
            else{s^=nums[i];}
        }
        int[] arr = new int[2];
        arr[0] = Math.min(f,s);
        arr[1] = Math.max(f,s);
        return arr;
    }
}