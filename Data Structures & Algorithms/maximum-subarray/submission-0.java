class Solution {
    public int maxSubArray(int[] nums) {
        int maxSum = nums[0];
        int cur = 0;

        for (int n : nums) {
            if (cur < 0) cur = 0;
            cur += n;
            maxSum = Math.max(maxSum, cur);
        }

        return maxSum;
    }
}
