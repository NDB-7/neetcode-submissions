class Solution {
    int[] nums;
    List<List<Integer>> res;
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        this.nums = nums;
        res = new ArrayList<List<Integer>>();
        List<Integer> path = new ArrayList<>();
        backtrack(target, path, 0);
        return res;
    }

    private void backtrack(int target, List<Integer> path, int i) {
        if (target == 0) {
            res.add(new ArrayList<>(path));
            return;
        }
        if (target < 0 || i >= nums.length) return;

        path.add(nums[i]);
        backtrack(target - nums[i], path, i);
        path.remove(path.size() - 1);
        backtrack(target, path, i + 1);
    }
}
