class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();

        for (String op : tokens) {
            int n2, n1;
            switch (op) {
                case "+":
                    stack.push(stack.pop() + stack.pop());
                    break;
                case "-":
                    n2 = stack.pop();
                    n1 = stack.pop();
                    stack.push(n1 - n2);
                    break;
                case "*":
                    stack.push(stack.pop() * stack.pop());
                    break;
                case "/":
                    n2 = stack.pop();
                    n1 = stack.pop();
                    stack.push(n1 / n2);
                    break;
                default:
                    stack.push(Integer.parseInt(op));
                    break;
            }
        }

        return stack.pop();
    }
}
