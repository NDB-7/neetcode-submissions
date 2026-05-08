class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] count = new int[26];

        for (char c : tasks) count[c - 'A']++;

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for (int t : count) if (t > 0) maxHeap.offer(t);

        Queue<int[]> q = new LinkedList<>();

        int time = 0;

        while (!maxHeap.isEmpty() || !q.isEmpty()) {
            time++;

            if (!maxHeap.isEmpty()) {
                int polled = maxHeap.poll() - 1;
                if (polled > 0) q.offer(new int[]{polled, time + n});
            }
            if (!q.isEmpty() && q.peek()[1] == time) maxHeap.offer(q.poll()[0]);
        }

        return time;
    }
}
