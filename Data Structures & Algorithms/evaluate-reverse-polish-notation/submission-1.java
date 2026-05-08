class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> s = new Stack<>();
        for (String t : tokens) {
            int num2;
            switch (t) {
                case "+":
                    s.push(s.pop() + s.pop());
                    break;
                case "-":
                    num2 = s.pop();
                    s.push(s.pop() - num2);
                    break;
                case "*":
                    s.push(s.pop() * s.pop());
                    break;
                case "/":
                    num2 = s.pop();
                    s.push(s.pop() / num2);
                    break;
                default:
                    s.push(Integer.parseInt(t));
                    break;
            }
        }

        return s.pop();
    }
}
