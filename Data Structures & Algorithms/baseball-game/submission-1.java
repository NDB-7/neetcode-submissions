class Solution {
    public int calPoints(String[] operations) {
        Stack<Integer> stack = new Stack();
        for (String op : operations) {
            int temp1, temp2;
            switch(op) {
                case "+":
                    temp1 = stack.pop();
                    temp2 = stack.peek();
                    stack.push(temp1);
                    stack.push(temp1 + temp2);
                    break;
                case "D":
                    stack.push(stack.peek() * 2);
                    break;
                case "C":
                    stack.pop();
                    break;
                default:
                    stack.push(Integer.parseInt(op));
                    break;
            }
        }

        int res = 0;
        while (!stack.isEmpty()) res += stack.pop();
        return res;
    }
}