class Solution {
    public ArrayList<ArrayList<Integer>> countFreq(int[] arr) {
        // code here
        Map<Integer,Integer>map=new HashMap<>();
        for(int val:arr)
        {
            map.put(val,map.getOrDefault(val,0)+1);
        }
        ArrayList<ArrayList<Integer>>result=new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            ArrayList<Integer>temp=new ArrayList<>();
            temp.add(entry.getKey());
            temp.add(entry.getValue());
            result.add(temp);
        }
        return result;
    }
}