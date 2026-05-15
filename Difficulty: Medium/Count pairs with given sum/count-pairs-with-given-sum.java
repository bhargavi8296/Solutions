class Solution {
    int countPairs(int arr[], int target) {
        // code here
        Map<Integer,Integer>map=new HashMap<>();
        map.put(0,0);
        int result=0;
        for(int val:arr)
        {
            if(map.containsKey(target-val))
            {
                result+=map.get(target-val);
            }
                map.put(val,map.getOrDefault(val,0)+1);
            
        }
        return result;
    }
}