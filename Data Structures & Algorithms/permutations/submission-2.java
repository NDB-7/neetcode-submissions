class Solution {
    int[] nums;
    List<List<Integer>> res;

    public List<List<Integer>> permute(int[] nums) {
        this.nums = nums;
        res = new ArrayList<List<Integer>>();
        boolean[] used = new boolean[nums.length];
        List<Integer> cur = new ArrayList<>();
        backtrack(cur, used);
        return res;
    }

    private void backtrack(List<Integer> cur, boolean[] used) {
        if (cur.size() == nums.length) {
            res.add(new ArrayList<>(cur));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (!used[i]) {
                cur.add(nums[i]);
                used[i] = true;
                backtrack(cur, used);
                cur.remove(cur.size() - 1);
                used[i] = false;
            }
        }
    }
}
