class Solution {
    public long subarrayXor(int arr[], int k) {
        // code here
        Map<Integer,Integer>map=new HashMap<>();
        int xor=0;
        map.put(0,1);
        long result=0;
        for(int val:arr)
        {
            xor^=val;
            int temp=map.getOrDefault(xor^k,0);
            result+=temp;
            map.put(xor,map.getOrDefault(xor,0)+1);
            //System.out.print(map);
        }
        return result;
    }
}