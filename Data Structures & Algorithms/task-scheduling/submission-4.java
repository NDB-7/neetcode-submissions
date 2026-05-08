class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] freq = new int[26];
        for (char c : tasks) freq[c - 'A']++;

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        Queue<int[]> q = new LinkedList<>();

        for (int t : freq) if (t > 0) maxHeap.offer(t);

        int time = 0;

        while (!maxHeap.isEmpty() || !q.isEmpty()) {
            time++;
            if (!maxHeap.isEmpty()) {
                int taskFreq = maxHeap.poll() - 1;
                if (taskFreq > 0) q.offer(new int[]{taskFreq, time + n});
            }

            if (!q.isEmpty() && q.peek()[1] == time) maxHeap.offer(q.poll()[0]);
        }

        return time;
    }
}
