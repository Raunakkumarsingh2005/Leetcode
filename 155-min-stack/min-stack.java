class MinStack {
    Stack<Integer> stack; // this stack is used to keep track of the min. element of array.
    Stack<Integer> minstack; // this is the main stack for performing push pop operations.

    public MinStack() {
        stack = new Stack<>();
        minstack = new Stack<>();
    }

    public void push(int val){
        if (minstack.isEmpty() || stack.peek() >= val) {
            stack.push(val);
        }

        minstack.push(val);
    }

    public void pop() {
        if (stack.peek().equals(minstack.peek())) {
            stack.pop();
        }

        minstack.pop();
    }

    public int top(){
        return minstack.peek();
    }

    public int getMin() {
        if (stack.isEmpty()) {
            return 0;
        }

        return stack.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */