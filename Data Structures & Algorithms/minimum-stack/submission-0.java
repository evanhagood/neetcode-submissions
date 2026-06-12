class MinStack<E extends Comparable<E>> {

    private Stack<E> stack;

    public MinStack() {
        this.stack = new Stack<>();
    }
    
    public void push(E val) {
        stack.push(val);
    }
    
    public void pop() {
        stack.pop();
    }
    
    public E top() {
        return stack.peek();
    }
    
    public E getMin() {
        Stack<E> temp = new Stack<>();
        E min = stack.peek();

        while(!stack.isEmpty()) {
            E curr = stack.pop();

            if(min.compareTo(curr) > 0) {
                min = curr;
            }

            temp.push(curr);
        }

        while(!temp.isEmpty()) {
            stack.push(temp.pop());
        }

        return min;
    }
}
