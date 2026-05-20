// User function Template for Java
class StackQueue {
    Stack<Integer>s1;
    Stack<Integer>s2;
    public StackQueue()
    {
        s1=new Stack<>();
        s2=new Stack<>();
    }
    public void push(int B) {
        // code here
        while(!s1.isEmpty())
        {
            s2.push(s1.pop());
        }
        s1.push(B);
        while(!s2.isEmpty())
        {
            s1.push(s2.pop());
        }
        
    }

    public int pop() {

        
        // code here
        if(s1.isEmpty()){return -1;}
        return s1.pop();
    }
}