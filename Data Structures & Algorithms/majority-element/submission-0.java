class Solution {
    public int majorityElement(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int highest = nums[0];

        for (int n : nums) {
            if (map.containsKey(n)) map.put(n, map.get(n) + 1);
            else map.put(n, 1);

            if (map.get(n) > map.get(highest)) highest = n;
        }

        return highest;
    }
}