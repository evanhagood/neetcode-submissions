/**
* Queue of Queues approach
* 
* Intuition: Instead of rearranging a queue structure, we can just use a linked list with a 
*            reference to the other nodes in the stack.
*
* This can be solved with either a normal linked list or with the Java Queue interface.
* For the spirit of this question, I chose the latter.
*/

class MyStack {

    // Queue will look like this:
    // [value] -> [reference to last head] -> [value] -> [reference to last head] ... etc
    // so pushing 1, 2, 3:
    // stack = [3, [2, [1, null]]]

    Queue<Object> stack;

    public MyStack() {
        stack = null;
    }
    
    public void push(int x) {
        Queue<Object> newStack = new LinkedList<>();

        newStack.offer(x);
        newStack.offer(stack);

        stack = newStack;
    }
    
    public int pop() {
        int ret = (int) stack.poll();
        stack = (Queue<Object>) stack.poll();
        return ret;
    }
    
    public int top() {
        return (stack == null) ? -1 : (int) stack.peek();
    }
    
    public boolean empty() {
        return stack == null;
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