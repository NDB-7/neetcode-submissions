class Solution {
    List<List<Integer>> res;
    int[] nums;

    public List<List<Integer>> subsets(int[] nums) {
        this.nums = nums;
        res = new ArrayList<List<Integer>>();
        List<Integer> path = new ArrayList<>();

        backtrack(path, 0);

        return res;
    }

    private void backtrack(List<Integer> path, int i) {
        if (i == nums.length) {
            res.add(new ArrayList<>(path));
            return;
        }
        path.add(nums[i]);
        backtrack(path, i + 1);
        path.remove(path.size() - 1);
        backtrack(path, i + 1);
    }
}
