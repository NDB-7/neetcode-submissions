class Twitter:
    def __init__(self):
        self.counter = 0
        self.user_tweets = {}
        self.user_following = {}
        self.user_followers = {}

    def postTweet(self, userId: int, tweetId: int) -> None:
        if not userId in self.user_tweets:
            self.user_tweets[userId] = []
        self.user_tweets[userId].append((self.counter, tweetId))
        self.counter += 1

    def getNewsFeed(self, userId: int) -> List[int]:
        following = [userId]
        if userId in self.user_following:
            for user in self.user_following[userId]:
                following.append(user)

        min_heap = []

        for user in following:
            if user in self.user_tweets:
                for tweet in self.user_tweets[user]:
                    heapq.heappush(min_heap, tweet)
                    if len(min_heap) > 10:
                        heapq.heappop(min_heap)
        
        res = []
        
        while min_heap:
            res.append(heapq.heappop(min_heap)[1])

        res.reverse()
        return res


    def follow(self, followerId: int, followeeId: int) -> None:
        if followerId != followeeId:
            if not followerId in self.user_following:
                self.user_following[followerId] = set()
            if not followeeId in self.user_followers:
                self.user_followers[followeeId] = set()
            self.user_following[followerId].add(followeeId)
            self.user_followers[followeeId].add(followerId)

    def unfollow(self, followerId: int, followeeId: int) -> None:
        if followerId != followeeId:
            self.user_following[followerId].discard(followeeId)
            self.user_followers[followeeId].discard(followerId)
        
