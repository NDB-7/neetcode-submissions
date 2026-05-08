public class TrieNode {
    TrieNode[] children;
    boolean endOfWord;

    public TrieNode() {
        children = new TrieNode[26];
        endOfWord = false;
    }
}

class WordDictionary {
    private TrieNode root;

    public WordDictionary() {
        root = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); ++i) {
            char c = word.charAt(i);
            if (node.children[c - 'a'] == null)
                node.children[c - 'a'] = new TrieNode();
            node = node.children[c - 'a'];
        }
        node.endOfWord = true;
    }

    public boolean search(String word) {
        return searchHelper(root, word);
    }

    private boolean searchHelper(TrieNode node, String word) {
        for (int i = 0; i < word.length(); ++i) {
            char c = word.charAt(i);
            if (c == '.') {
                boolean found = false;
                for (int j = 0; j < node.children.length; j++) {
                    TrieNode child = node.children[j];
                    if (child != null)
                        found = found || searchHelper(child, word.substring(i + 1));
                }
                return found;
            } else node = node.children[c - 'a'];
            if (node == null) return false;
        }
        return node.endOfWord;
    }
}
