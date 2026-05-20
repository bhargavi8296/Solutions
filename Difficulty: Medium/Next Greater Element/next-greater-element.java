class Solution {
    public ArrayList<Integer> nextLargerElement(int[] arr) {
        // code here
        ArrayList<Integer>list=new ArrayList<>();
        Stack<Integer>s=new Stack<>();
        for(int i=arr.length-1;i>=0;--i)
        {
            while(!s.isEmpty()&&s.peek()<=arr[i]){s.pop();}
            //System.out.println(s);
            int temp=s.isEmpty()?-1:s.peek();
            s.push(arr[i]);
            list.add(temp);
        }
        Collections.reverse(list);
        return list;
    }
}