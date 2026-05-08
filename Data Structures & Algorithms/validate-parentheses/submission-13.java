class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        Map<Character, Character> m = new HashMap<>();
        m.put(')', '(');
        m.put(']', '[');
        m.put('}', '{');

        for (char c : s.toCharArray()) {
            if (m.containsKey(c) && !stack.isEmpty() && stack.peek() == m.get(c)) {
                stack.pop();
            } else stack.push(c);
        }

        return stack.isEmpty();
    }
}
