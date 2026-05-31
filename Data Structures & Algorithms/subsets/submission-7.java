class Solution {
    List<List<Integer>> res;
    int[] nums;

    public List<List<Integer>> subsets(int[] nums) {
        res = new ArrayList<>();
        this.nums = nums;
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
