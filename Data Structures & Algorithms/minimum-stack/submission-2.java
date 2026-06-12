class MinStack<E extends Comparable> {

    private Stack<E> stack;
    private Stack<E> minStack;

    public MinStack() {
        this.stack = new Stack<>();
        this.minStack = new Stack<>();
    }
    
    public void push(E val) {
        stack.push(val);
        if(minStack.isEmpty() || minStack.peek().compareTo(val) >= 0) {
            minStack.push(val);
        }
    }
    
    public void pop() {
        if(stack.isEmpty()) return;
        E top = stack.pop();
        if(top.equals(minStack.peek())) {
            minStack.pop();
        }
    }
    
    public E top() {
        return stack.peek();
    }
    
    public E getMin() {
        return minStack.peek();
    }
}
