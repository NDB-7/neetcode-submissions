class Solution {
    int[] nums;
    List<List<Integer>> res;

    public List<List<Integer>> subsets(int[] nums) {
        this.nums = nums;
        this.res = new ArrayList<List<Integer>>();

        List<Integer> path = new ArrayList<>();
        backtrack(0, path);

        return res;
    }

    private void backtrack(int i, List<Integer> path) {
        if (i == nums.length) {
            res.add(new ArrayList<>(path));
            return;
        }

        path.add(nums[i]);
        backtrack(i + 1, path);
        path.remove(path.size() - 1);
        backtrack(i + 1, path);
    }
}
