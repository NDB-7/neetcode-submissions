class Solution {
    public int calPoints(String[] operations) {
        Stack<Integer> stack = new Stack<>();

        for (String s : operations) {
            if (s.equals("+")) {
                int num = stack.pop();
                int result = num + stack.peek();
                stack.push(num);
                stack.push(result);
            } else if (s.equals("D")) {
                int result = stack.peek() * 2;
                stack.push(result);
            } else if (s.equals("C")) {
                stack.pop();
            } else {
                int num = Integer.parseInt(s);
                stack.push(num);
            }
        }

        int result = 0;

        while (!stack.isEmpty()) {
            result += stack.pop();
        }

        return result;
    }
}