class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int key : nums) {
            map.put(key, map.getOrDefault(key, 0) + 1);
        }

        int[] res = new int[k];
        HashSet<Integer> set = new HashSet<>();

        for (int j = 0; j < k; j++) {
            int key = 0;
            int maxFreq = 0;

            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                int freq = entry.getValue();
                if (freq > maxFreq && !set.contains(entry.getKey())) {
                    key = entry.getKey();
                    maxFreq = freq;
                }
            }

            res[j] = key;
            set.add(key);
        }

        return res;
    }
}
