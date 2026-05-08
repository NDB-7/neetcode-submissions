class Solution {
    public int searchInsert(int[] nums, int target) {
        return search(nums, target, 0, nums.length - 1);
    }

    private int search(int[] nums, int target, int l, int r) {
        int m = (l + r) / 2;
        int val = nums[m];
        if (l > r) {
            int returnValue = (val < target) ? m + 1 : m - 1;
            if (returnValue < 0) returnValue = 0;
            return returnValue;
        }
        if (val == target) return m;
        else if (val > target) return search(nums, target, l, m - 1);
        else return search(nums, target, m + 1, r);
    }
}