class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] res = new int[temperatures.length];
        Stack<int[]> s = new Stack<>();

        for (int i = 0; i < temperatures.length; i++) {
            int temp = temperatures[i];
            while (!s.isEmpty() && s.peek()[0] < temp) {
                int[] popped = s.pop();
                res[popped[1]] = i - popped[1];
            }
            s.add(new int[]{temp, i});
        }

        return res;
    }
}
