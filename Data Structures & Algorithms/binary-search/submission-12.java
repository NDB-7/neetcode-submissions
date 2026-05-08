class Solution {
    public int search(int[] nums, int target) {
        int l = 0, r = nums.length - 1;

        while (l <= r) {
            int m = l + (r - l) / 2;
            int n = nums[m];

            if (target < n) r = m - 1;
            else if (target > n) l = m + 1;
            else return m;
        }

        return -1;
    }
}
