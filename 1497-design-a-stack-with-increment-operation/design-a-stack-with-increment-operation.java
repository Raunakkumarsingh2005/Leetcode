class CustomStack {
    Stack<Integer> s1;
    Stack<Integer> s2;
    int size;

    public CustomStack(int maxSize) {
        s1 = new Stack<>();
        s2 = new Stack<>();
        size = maxSize;
    }
    
    public void push(int x) {
        if (size > 0) {
            s1.push(x);
            size--;
        }
    }
    
    public int pop() {
        if (s1.isEmpty()) {
            return -1;
        }
        
        size++;
        return s1.pop();
    }
    
    public void increment(int k, int val) {
        //copying the elements of s1 to s2
        while (!s1.isEmpty()) {
            s2.push(s1.pop());
        }
        
        //moving elements from s2 to s1 with add ing val to numbers
        while (!s2.isEmpty()) {
            //performs addition to first k elements in s2
            if (k > 0) {
                int j = val + s2.pop();
                s1.push(j);
                k--;
            }

            //add the rest of the elemnts from s2 to s1
            else{
                s1.push(s2.pop());
            }
        }
    }
}

/**
 * Your CustomStack object will be instantiated and called as such:
 * CustomStack obj = new CustomStack(maxSize);
 * obj.push(x);
 * int param_2 = obj.pop();
 * obj.increment(k,val);
 */