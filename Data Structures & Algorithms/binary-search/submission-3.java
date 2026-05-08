class Solution {
    public int search(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        return binarySearch(nums, target, l, r);
    }

    public int binarySearch(int[] nums, int target, int l, int r) {
        if (l <= r) {
            int m = l + (r - l) / 2;
            int num = nums[m];

            if (num < target) {
                return binarySearch(nums, target, m + 1, r);
            } else if (num > target) {
                return binarySearch(nums, target, l, m - 1);
            } else {
                return m;
            }
        } else {
            return -1;
        }
    }
}
