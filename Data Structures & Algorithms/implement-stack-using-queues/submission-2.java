class MyStack {
    private Queue<Integer> q;

    private void helper() {
        int size = q.size();
        while (size > 1) {
            q.add(q.remove());
            size--;
        }
    }

    public MyStack() {
        q = new LinkedList<>();
    }
    
    public void push(int x) {
        q.add(x);
    }
    
    public int pop() {
        helper();
        return q.remove();
    }
    
    public int top() {
        helper();
        int value = q.remove();
        q.add(value);
        return value;
    }
    
    public boolean empty() {
        return q.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */