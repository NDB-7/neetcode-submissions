class Solution {
    public int[] productExceptSelf(int[] nums) {
        Set<Integer> zeroIndices = new HashSet<>();
        int[] res = new int[nums.length];
        int product = 1;

        for (int i = 0; i < nums.length; i++) {
            int n = nums[i];
            if (n == 0) zeroIndices.add(i);
            else product *= n;
        }

        if (zeroIndices.size() > 1) return res;

        for (int i = 0; i < nums.length; i++) {
            if (!zeroIndices.isEmpty()) {
                if (zeroIndices.contains(i)) res[i] = product;
                else res[i] = 0;
            } else res[i] = product / nums[i];
        }

        return res;
    }
}  
