class Solution {
    int[] nums;
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        this.nums = nums;
        List<Integer> currPath = new ArrayList<>();
        backtrack(0, currPath);
        return res;
    }

    private void backtrack(int index, List<Integer> currPath) {
        if (index == nums.length) {
            res.add(new ArrayList<>(currPath));
            return;
        }

        currPath.add(nums[index]);
        backtrack(index + 1, currPath);
        currPath.remove(currPath.size() - 1);
        backtrack(index + 1, currPath);
    }
}
