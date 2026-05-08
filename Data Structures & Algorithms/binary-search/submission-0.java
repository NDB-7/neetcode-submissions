class Solution {
    public int search(int[] nums, int target) {
        return findMe(nums, target, 0, nums.length - 1);
    }

    private int findMe(int[] nums, int target, int start, int end) {
        if (start > end) return -1;
        int middle = (start + end) / 2;
        int val = nums[middle];

        if (val == target) return middle;
        else if (val > target) return findMe(nums, target, start, middle - 1);
        else return findMe(nums, target, middle + 1, end);
    }
}
