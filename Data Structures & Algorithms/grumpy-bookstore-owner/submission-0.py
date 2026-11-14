class Solution:
    def maxSatisfied(self, customers: List[int], grumpy: List[int], minutes: int) -> int:
        # Goal: satisfy max customers
        # Within window, track how many are unsatisfied
            # Try to maximize that number
        # Also, track how many customers are satisfied already
        # Subtract unsatisfied from total, return as response        
        base_satisfied = 0
        for i in range(len(customers)):
            if grumpy[i] == 0:
                base_satisfied += customers[i]

        extra_satisfied = 0
        for i in range(minutes):
            if grumpy[i] == 1:
                extra_satisfied += customers[i]
        
        max_extra_satisfied = extra_satisfied

        for r in range(minutes, len(customers)):
            if grumpy[r - minutes] == 1: # Unsatisfied leaving window
                extra_satisfied -= customers[r - minutes]
            if grumpy[r] == 1: # Unsatisfied entering window
                extra_satisfied += customers[r]
            max_extra_satisfied = max(max_extra_satisfied, extra_satisfied)
        
        return base_satisfied + max_extra_satisfied