class Node:
    def __init__(self, val):
        self.val = val
        self.next = None

class MyHashSet:

    def __init__(self):
        self.hash_set = [Node(0) for _ in range(10**4)]

    def add(self, key: int) -> None:
        cur = self.hash_set[key % len(self.hash_set)]
        while cur.next:
            if cur.next.val == key:
                return
            cur = cur.next
        cur.next = Node(key)

    def remove(self, key: int) -> None:
        cur = self.hash_set[key % len(self.hash_set)]
        while cur.next:
            if cur.next.val == key:
                cur.next = cur.next.next
                return
            cur = cur.next

    def contains(self, key: int) -> bool:
        cur = self.hash_set[key % len(self.hash_set)]
        while cur.next:
            cur = cur.next
            if cur.val == key:
                return True
        return False



# Your MyHashSet object will be instantiated and called as such:
# obj = MyHashSet()
# obj.add(key)
# obj.remove(key)
# param_3 = obj.contains(key)