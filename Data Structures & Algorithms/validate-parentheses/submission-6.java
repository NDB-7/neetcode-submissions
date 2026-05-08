class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        HashMap<Character, Character> openToClose = new HashMap<>();
        openToClose.put('{', '}');
        openToClose.put('(', ')');
        openToClose.put('[', ']');

        for (char c : s.toCharArray()) {
            if (openToClose.containsKey(c)) stack.push(c);
            else if (stack.isEmpty()) return false;
            else if (openToClose.get(stack.pop()) != c) return false;
        }

        return stack.isEmpty(); // No remaining open brackets left
    }
}
