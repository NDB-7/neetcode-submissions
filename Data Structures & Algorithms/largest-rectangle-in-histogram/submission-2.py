class Solution:
    def largestRectangleArea(self, heights: List[int]) -> int:
        res = 0
        stack = []

        for i in range(len(heights)):
            start = i
            while stack and stack[-1][0] > heights[i]:
                height, index = stack.pop()
                res = max(res, height * (i - index))
                start = index
            stack.append((heights[i], start))

        for h, i in stack:
            res = max(res, h * (len(heights) - i))

        return res