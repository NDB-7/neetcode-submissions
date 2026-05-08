class Solution {
    public int removeDuplicates(int[] nums) {
        int l = 1, r = 1;

        while (r < nums.length) {
            if (nums[r - 1] != nums[r]) nums[l++] = nums[r];
            r++;
        }

        return l;
    }
}