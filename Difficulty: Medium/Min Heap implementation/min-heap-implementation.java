class minHeap {

    // Constructor
    int arr[];
    int size;
    int top;
    public minHeap() {
        // Initialize your data members
        arr=new int[10001];
        size=-1;
    }

    public void push(int x) {
        // Insert x into the heap
        arr[++size]=x;
        int n=size;
        while(n!=0)
        {
            if(arr[(n-1)/2]>arr[n])
            {
                int temp=arr[(n-1)/2];
                arr[(n-1)/2]=arr[n];
                arr[n]=temp;
            }
            n=(n-1)/2;
        }
    }
    public void helper(int start, int size)
    {
        int smallest = start;

    int left = 2*start + 1;
    int right = 2*start + 2;

    if (left <= size && arr[left] < arr[smallest]) {
        smallest = left;
    }

    if (right <= size && arr[right] < arr[smallest]) {
        smallest = right;
    }

    if (smallest != start) {
        int temp = arr[start];
        arr[start] = arr[smallest];
        arr[smallest] = temp;

        helper(smallest, size);
    }
    }
    public void pop() {
        // Remove the top (minimum) element
        
        int temp=arr[0];
        arr[0]=arr[size];
        arr[size]=temp;
        --size;
        
            helper(0,size);
        
        
        
    }

    public int peek() {
        // Return the top element or -1 if empty
        if(size==-1){return -1;}
        return arr[0];
    }

    public int size() {
        // Return the number of elements in the heap
        return size+1;
    }
}
