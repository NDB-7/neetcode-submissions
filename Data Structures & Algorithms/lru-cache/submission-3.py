class Node:
    def __init__(self, key, val):
        self.key, self.val = key, val
        self.prv = self.nxt = None

class LRUCache:

    def __init__(self, capacity: int):
        self.cap = capacity
        self.cache = {}
        self.head, self.tail = Node(0, 0), Node(0, 0) # head for LRU, tail for MRU
        self.head.nxt, self.tail.prv = self.tail, self.head
    
    def _insert(self, node):
        prv = self.tail.prv
        nxt = self.tail
        prv.nxt = nxt.prv = node
        node.prv, node.nxt = prv, nxt
    
    def _remove(self, node):
        prv = node.prv
        nxt = node.nxt
        prv.nxt, nxt.prv = nxt, prv

    def get(self, key: int) -> int:
        if not key in self.cache:
            return -1

        node = self.cache[key]
        self._remove(node)
        self._insert(node)

        return node.val

    def put(self, key: int, value: int) -> None:
        if key in self.cache:
            node = self.cache[key]
            self._remove(node)
            self._insert(node)
            node.val = value
        else:
            node = Node(key, value)
            self.cache[key] = node
            self._insert(node)
        
        if len(self.cache) > self.cap:
            lru = self.head.nxt
            self._remove(lru)
            del self.cache[lru.key]
        
