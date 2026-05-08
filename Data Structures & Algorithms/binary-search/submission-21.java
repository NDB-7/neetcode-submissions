class Solution {
    public int search(int[] nums, int target) {
        return binarySearch(nums, target, 0, nums.length - 1);
    }

    private int binarySearch(int[] nums, int target, int l, int r) {
        if (l > r) return -1;

        int m = l + (r - l) / 2;
        int n = nums[m];

        if (n < target) return binarySearch(nums, target, m + 1, r);
        else if (n > target) return binarySearch(nums, target, l, m - 1);
        else return m;
    }
}
