class Solution {
    int[] nums;
    List<List<Integer>> res;

    public List<List<Integer>> permute(int[] nums) {
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

        for (int num : nums) {
            if (cur.contains(num)) continue;
            cur.add(num);
            backtrack(i + 1, cur);
            cur.remove(cur.size() - 1);
        }
    }
}
