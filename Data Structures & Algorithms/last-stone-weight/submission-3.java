class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> heap = new PriorityQueue(Collections.reverseOrder());

        for (int s : stones) heap.offer(s);

        while (heap.size() > 1) {
            int s1 = heap.poll();
            int s2 = heap.poll();

            if (s1 > s2) heap.offer(s1 - s2);
        }

        heap.offer(0);
        return heap.peek();
    }
}
