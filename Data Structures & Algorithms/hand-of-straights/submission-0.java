class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if (hand.length % groupSize != 0) return false;

        Map<Integer, Integer> map = new HashMap<>();
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (int n : hand) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }

        for (int n : map.keySet()) minHeap.offer(n);

        while (!minHeap.isEmpty()) {
            int cur = minHeap.peek();

            if (map.get(cur) == 0) {
                minHeap.poll();
                continue;
            }

            int count = map.get(cur);

            for (int i = cur; i < cur + groupSize; i++) {
                int curCount = map.getOrDefault(i, 0);
                if (curCount < count) return false;
                map.put(i, curCount - count);
            }
        }

        return true;
    }
}
