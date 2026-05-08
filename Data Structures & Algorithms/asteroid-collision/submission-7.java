class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> s = new Stack<>();

        for (int ast : asteroids) {
            if (s.isEmpty() || ast > 0 || s.peek() < 0) s.push(ast);
            else {
                if (s.peek() == -ast) s.pop();
                else {
                    while (!s.isEmpty() && s.peek() > 0 && s.peek() < -ast) s.pop();
                    if (s.isEmpty() || s.peek() < 0) s.push(ast);
                    else if (s.peek() == -ast) s.pop();
                }
            }
        }

        Stack<Integer> reversed = new Stack<>();
        while (!s.isEmpty()) reversed.push(s.pop());
        int[] res = new int[reversed.size()];
        int i = 0;
        while (!reversed.isEmpty()) res[i++] = reversed.pop();
        return res;
    }
}