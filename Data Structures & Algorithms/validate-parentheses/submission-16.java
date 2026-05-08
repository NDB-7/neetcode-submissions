class Solution {
    public boolean isValid(String s) {
        Map<Character, Character> m = new HashMap<>();
        m.put(']', '[');
        m.put(')', '(');
        m.put('}', '{');
        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            if (m.containsKey(c)) {
                if (stack.isEmpty()) return false;
                if (stack.pop() != m.get(c)) return false;
            } else stack.push(c);
        }

        return stack.isEmpty();
    }
}
