class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int currTank = 0;
        int totalGas = 0;
        int totalCost = 0;
        int start = 0;

        for (int i = 0; i < gas.length; i++) {
            currTank += gas[i] - cost[i];
            totalGas += gas[i];
            totalCost += cost[i];

            if (currTank < 0) {
                currTank = 0;
                start = i + 1;
            }
        }

        return (totalGas < totalCost) ? -1 : start;
    }
}
