class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] count = new int[26];
        for (char t : tasks) count[t - 'A']++;

        // Max heap will only contain tasks ready to process
        // We want to process most frequent task first
        // That will always be retrieved wtih maxHeap.poll()
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for (int t : count) if (t > 0) maxHeap.offer(t);

        int time = 0;
        // [freq, readyTime]
        Queue<int[]> q = new LinkedList<>();

        while (!maxHeap.isEmpty() || !q.isEmpty()) {
            time++;
            if (!maxHeap.isEmpty()) {
                int taskFreq = maxHeap.poll();
                if (taskFreq > 1) q.offer(new int[]{taskFreq - 1, time + n});
                // Task will be ready to add into heap again at time + n
            }
            if (!q.isEmpty() && time == q.peek()[1]) maxHeap.offer(q.poll()[0]);
        }

        return time;
    }
}
