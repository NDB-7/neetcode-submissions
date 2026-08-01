class MedianFinder:

    def __init__(self):
        self.less = [] # max heap
        self.more = [] # min heap

    def addNum(self, num: int) -> None:
        if self.more and num > self.more[0]:
            heapq.heappush(self.more, num)
        else:
            heapq.heappush(self.less, -num)

        if len(self.less) > len(self.more) + 1:
            heapq.heappush(self.more, -heapq.heappop(self.less))
        if len(self.more) > len(self.less) + 1:
            heapq.heappush(self.less, -heapq.heappop(self.more))

    def findMedian(self) -> float:
        if len(self.less) > len(self.more):
            return -self.less[0]
        elif len(self.more) > len(self.less):
            return self.more[0]
        else:
            return (-self.less[0] + self.more[0]) / 2.0
        