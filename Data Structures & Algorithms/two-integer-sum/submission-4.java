class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> m = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            int diff = target - num;

            if (m.containsKey(diff)) return new int[] {m.get(diff), i};
            else m.put(num, i);
        }

        return null;
    }
}
