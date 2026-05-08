class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        HashMap<Character, Character> openToClose = new HashMap<>();
        openToClose.put('{', '}');
        openToClose.put('(', ')');
        openToClose.put('[', ']');

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (openToClose.containsKey(c)) stack.push(c);
            else if (stack.isEmpty()) return false;
            else if (openToClose.get(stack.pop()) != c) return false;
        }

        return stack.isEmpty();
    }
}
