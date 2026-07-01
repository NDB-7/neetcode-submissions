class Solution {
    public boolean mergeTriplets(int[][] triplets, int[] target) {
        int[] t = {0, 0, 0};

        for (int i = 0; i < triplets.length; i++) {
            int[] tC = triplets[i];
            int[] merged = new int[] {Math.max(t[0], tC[0]), Math.max(t[1], tC[1]), Math.max(t[2], tC[2])};

            boolean skip = false;

            for (int j = 0; j < 3; j++) skip = skip || (merged[j] > target[j]);

            if (skip) continue;
            t = merged;
        }

        return t[0] == target[0] && t[1] == target[1] && t[2] == target[2];
    }
}
