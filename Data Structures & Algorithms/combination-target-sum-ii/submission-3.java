class Solution {
    List<List<Integer>> res;
    int[] candidates;

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        this.candidates = candidates;
        this.res = new ArrayList<List<Integer>>();
        List<Integer> path = new ArrayList<>();

        backtrack(0, path, target);

        return res;
    }

    private void backtrack(int i, List<Integer> path, int target) {
        if (target <= 0 || i == candidates.length) {
            if (target == 0) res.add(new ArrayList<>(path));
            return;
        }
        
        path.add(candidates[i]);
        backtrack(i + 1, path, target - candidates[i]);
        path.remove(path.size() - 1);

        while (i < candidates.length - 1 && candidates[i] == candidates[i + 1]) i++;
        
        backtrack(i + 1, path, target);
    }
}
