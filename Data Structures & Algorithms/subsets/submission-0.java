class Solution {
    int[] nums;
    List<List<Integer>> list = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        this.nums = nums;
        List<Integer> curr = new ArrayList<>();
        backtrack(0, curr);
        return list;
    }

    private void backtrack(int index, List<Integer> curr) {
        if (index == nums.length) {
            list.add(new ArrayList<>(curr));
            return;
        }

        curr.add(nums[index]);
        backtrack(index + 1, curr);
        curr.remove(curr.size() - 1);
        backtrack(index + 1, curr);
    }
}
