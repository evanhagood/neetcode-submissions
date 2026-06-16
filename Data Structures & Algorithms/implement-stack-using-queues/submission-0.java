class MyStack {

    Queue<Integer> stack;

    public MyStack() {
        this.stack = new LinkedList<>();
    }
    
    /**
    * Queues are only FIFO - every time we push(), we need to rotate
    * the pushed value to the front of the queue.
    *
    * I like this as an excercise but this seems irrelevant when Deque() exists.
    */
    public void push(int x) {
        stack.offer(x);
        for(int i = 0; i < stack.size() - 1; i++) {
            stack.offer(stack.poll());
        }
    }
    
    public int pop() {
        return stack.poll();
    }
    
    public int top() {
        return stack.peek();
    }
    
    public boolean empty() {
        return stack.isEmpty();
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