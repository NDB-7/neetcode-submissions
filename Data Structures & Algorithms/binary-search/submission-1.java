class Solution {
    public int search(int[] nums, int target) {
        return find(nums, target, 0, nums.length - 1);
    }

    private int find(int[] nums, int target, int l, int r) {
        if (l > r) return -1;
        int m = (l + r) / 2;
        int val = nums[m];
        
        if (val == target) return m;
        else if (val > target) return find(nums, target, l, m - 1);
        else return find(nums, target, m + 1, r);
    }
}
