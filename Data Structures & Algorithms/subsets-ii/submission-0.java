class Solution {
    int[] nums;
    List<List<Integer>> res;
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        this.nums = nums;
        res = new ArrayList<List<Integer>>();
        List<Integer> cur = new ArrayList<>();
        backtrack(0, cur);
        return res;
    }

    private void backtrack(int i, List<Integer> cur) {
        if (i == nums.length) {
            res.add(new ArrayList<>(cur));
            return;
        }

        cur.add(nums[i]);
        backtrack(i + 1, cur);
        cur.remove(cur.size() - 1);
        while (i < nums.length - 1 && nums[i] == nums[i + 1]) i++;
        backtrack(i + 1, cur);
    }
}
