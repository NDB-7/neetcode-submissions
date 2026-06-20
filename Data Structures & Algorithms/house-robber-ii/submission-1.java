class Solution {
    public int rob(int[] nums) {
        if (nums.length == 1) return nums[0];

        return Math.max(robHelper(nums, 0, nums.length - 1), robHelper(nums, 1, nums.length));
    }

    private int robHelper(int[] nums, int start, int end) {
        int rob1 = 0, rob2 = 0;
        for (int i = start; i < end; i++) {
            int n = nums[i];
            int temp = Math.max(rob1 + n, rob2);
            rob1 = rob2;
            rob2 = temp;
        }

        return rob2;
    }
}
