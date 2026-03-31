class Solution {
    Map<Integer,List<Character>>map;
    List<String>result;
    public void helper(String digits,int i,String str)
    {
        if(i>=digits.length()){result.add(str);return;}
        //System.out.print(map.get(Integer.valueOf(digits.charAt(i)+"")));
        for(char ch:map.get(Integer.valueOf(digits.charAt(i)+"")))
        {
            helper(digits,i+1,str+ch);
        }
    }
    public List<String> letterCombinations(String digits) {
        map=new HashMap<>();
        map.put(2,new ArrayList<>());map.get(2).add('a');map.get(2).add('b'); map.get(2).add('c');
        map.put(3,new ArrayList<>());map.get(3).add('d');map.get(3).add('e');map.get(3).add('f');
        map.put(4,new ArrayList<>());map.get(4).add('g');map.get(4).add('h');map.get(4).add('i');
        map.put(5,new ArrayList<>());map.get(5).add('j');map.get(5).add('k');map.get(5).add('l');
        map.put(6,new ArrayList<>());map.get(6).add('m');map.get(6).add('n');map.get(6).add('o');
        map.put(7,new ArrayList<>());map.get(7).add('p');map.get(7).add('q');map.get(7).add('r');map.get(7).add('s');
        map.put(8,new ArrayList<>());map.get(8).add('t');map.get(8).add('u');map.get(8).add('v');
        map.put(9,new ArrayList<>());map.get(9).add('w');map.get(9).add('x');map.get(9).add('y');map.get(9).add('z');
        result=new ArrayList<>();
        helper(digits,0,"");
        return result;
    }
}