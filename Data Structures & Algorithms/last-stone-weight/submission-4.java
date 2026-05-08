class Solution {
    PriorityQueue<Integer> maxHeap;
    public int lastStoneWeight(int[] stones) {
        this.maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for (int s : stones) maxHeap.offer(s);
        while (!maxHeap.isEmpty()) {
            if (maxHeap.size() == 1) return maxHeap.poll();
            int x = maxHeap.poll();
            int y = maxHeap.poll();
            if (y < x) maxHeap.offer(x - y);
        }

        return 0;
    }
}
