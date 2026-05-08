class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        int i = 0, j = 0;
        HashSet<Integer> set = new HashSet<>();

        while (j < nums.length) {
            if (j - i > k) set.remove(nums[i++]);
            if (set.contains(nums[j])) return true;
            set.add(nums[j++]);
        }

        return false;
    }
}