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

        return s.stream().mapToInt(i -> i).toArray();
    }
}