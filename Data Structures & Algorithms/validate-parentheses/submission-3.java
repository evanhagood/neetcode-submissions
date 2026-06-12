class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < s.length(); i++) {
            char curr = s.charAt(i);
            if(curr == '{' || curr == '[' || curr == '(') {
                stack.push(curr);
            } else {
                if(stack.isEmpty()) return false;
                char popped = stack.pop();
                if(curr == '}' && popped != '{' ||
                   curr == ']' && popped != '[' ||
                   curr == ')' && popped != '('
                ) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}