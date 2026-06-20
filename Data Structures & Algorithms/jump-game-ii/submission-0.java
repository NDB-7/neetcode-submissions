class Solution {
    public int jump(int[] nums) {
        int jumps = 0;
        int l = 0;
        int r = 0;

        while (r < nums.length - 1) {
            int temp = r;
            for (int i = l; i <= temp; i++) {
                r = Math.max(i + nums[i], r);
            }
            l = temp + 1;
            jumps++;
        }

        return jumps;
    }
}
