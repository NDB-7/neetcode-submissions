class MyStack {
    private Queue<Integer> q0;
    private Queue<Integer> q1;
    int currentQueue = 0;

    public MyStack() {
        q0 = new LinkedList<>();
        q1 = new LinkedList<>();
    }
    
    public void push(int x) {
        Queue<Integer> q = (currentQueue == 0) ? q0 : q1;
        q.add(x);
    }
    
    public int pop() {
        Queue<Integer> q = (currentQueue == 0) ? q0 : q1;
        Queue<Integer> other = (currentQueue != 0) ? q0 : q1;

        while (q.size() > 1) {
            other.add(q.remove()); // Enqueue all but last
        }
        currentQueue = (currentQueue + 1) % 2;
        return q.remove();
    }
    
    public int top() {
        Queue<Integer> q = (currentQueue == 0) ? q0 : q1;
        Queue<Integer> other = (currentQueue != 0) ? q0 : q1;

        while (q.size() > 1) {
            other.add(q.remove()); // Enqueue all but last
        }

        int value = q.remove();
        currentQueue = (currentQueue + 1) % 2;
        other.add(value);
        return value;
    }
    
    public boolean empty() {
        return q0.isEmpty() && q1.isEmpty();
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