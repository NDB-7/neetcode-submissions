class Solution {
    public int search(int[] nums, int target) {
        return binarySearch(nums, target, 0, nums.length - 1);
    }

    private int binarySearch(int[] nums, int target, int l, int r) {
        if (l > r) return -1;
        int m = (l + r) / 2;
        if (nums[m] == target) return m;
        else if (nums[m] < target) return binarySearch(nums, target, m + 1, r);
        else return binarySearch(nums, target, l, m - 1);
    }
}
