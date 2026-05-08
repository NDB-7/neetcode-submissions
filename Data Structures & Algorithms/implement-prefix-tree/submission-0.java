class PrefixTree {
    private PrefixTree[] children;
    private boolean endOfWord;

    public PrefixTree() {
         children = new PrefixTree[26];
         endOfWord = false;
    }

    public void insert(String word) {
        PrefixTree node = this;
        for (int i = 0; i < word.length(); ++i) {
            char c = word.charAt(i);
            if (node.children[c - 'a'] == null)
                node.children[c - 'a'] = new PrefixTree();
            node = node.children[c - 'a'];
        }
        node.endOfWord = true;
    }

    public boolean search(String word) {
        PrefixTree node = this;
        for (int i = 0; i < word.length(); ++i) {
            char c = word.charAt(i);
            node = node.children[c - 'a'];
            if (node == null) return false;
        }
        return node.endOfWord;
    }

    public boolean startsWith(String prefix) {
        PrefixTree node = this;
        for (int i = 0; i < prefix.length(); ++i) {
            char c = prefix.charAt(i);
            node = node.children[c - 'a'];
            if (node == null) return false;
        }
        return true;
    }
}
