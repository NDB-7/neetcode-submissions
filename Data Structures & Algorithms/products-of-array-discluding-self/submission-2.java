class Solution {
    public int[] productExceptSelf(int[] nums) {
        int zeroCount = 0;
        int[] res = new int[nums.length];
        int product = 1;

        for (int n : nums) {
            if (n == 0) zeroCount++;
            else product *= n;
        }

        if (zeroCount > 1) return res;

        for (int i = 0; i < nums.length; i++) {
            if (zeroCount == 1)
                res[i] = (nums[i] == 0) ? product : 0;
            else res[i] = product / nums[i];
        }

        return res;
    }
}  
