class Solution:
    def makesquare(self, matchsticks: List[int]) -> bool:
        perimeter = sum(matchsticks)
        if perimeter % 4 != 0:
            return False
        side_length = perimeter // 4
        sides = [0] * 4
        matchsticks.sort(reverse = True)
        
        def dfs(i):
            if sides[0] > side_length or sides[1] > side_length or sides[2] > side_length or sides[3] > side_length:
                return False

            if i == len(matchsticks):
                return sides[0] == sides[1] == sides[2] == sides[3]
            
            for side in range(4):
                if sides[side] + matchsticks[i] <= side_length:
                    sides[side] += matchsticks[i]
                    if dfs(i + 1):
                        return True
                    sides[side] -= matchsticks[i]
            
            return False
        
        return dfs(0)