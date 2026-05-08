class MinStack {
    private Stack<Integer> s;
    private Stack<Integer> minS;

    public MinStack() {
        s = new Stack<>();
        minS = new Stack<>();
    }
    
    public void push(int val) {
        s.push(val);
        if (minS.isEmpty() || minS.peek() >= val) minS.push(val);
    }
    
    public void pop() {
        if (s.isEmpty()) return;
        int top = s.pop();
        if (top == minS.peek()) minS.pop();
    }
    
    public int top() {
        return s.peek();
    }
    
    public int getMin() {
        return minS.peek();
    }
}
