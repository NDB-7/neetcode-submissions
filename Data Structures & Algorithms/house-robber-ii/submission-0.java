class Solution {
    boolean robbedFirst = false;

    public int rob(int[] nums) {
        if (nums.length == 1) return nums[0];

        int[] nums1 = Arrays.copyOfRange(nums, 0, nums.length - 1);
        int[] nums2 = Arrays.copyOfRange(nums, 1, nums.length);

        return Math.max(robHelper(nums1), robHelper(nums2));
    }

    private int robHelper(int[] nums) {
        int rob1 = 0, rob2 = 0;
        for (int n : nums) {
            int temp = Math.max(rob1 + n, rob2);
            rob1 = rob2;
            rob2 = temp;
        }

        return rob2;
    }
}
