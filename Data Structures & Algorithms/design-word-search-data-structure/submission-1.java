class WordDictionary {
    private TrieNode root;
    public WordDictionary() {
        this.root = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode curr = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            int index = ch - 'a';
            if (curr.children[index] == null) {
                curr.children[index] = new TrieNode();
            }
            curr = curr.children[index];
        }
        curr.isEnd = true;
    }

    public boolean search(String word) {
        return dfs(word, 0, root);
    }

    private boolean dfs(String word, int index, TrieNode curr) {
        if (index == word.length()) {
            return curr.isEnd;
        }
        char ch = word.charAt(index);
        if (ch != '.') {
            int idx = ch - 'a';
            if (curr.children[idx] == null) {
                return false;
            }
            return dfs(word, index + 1, curr.children[idx]);
        }
        for (int i = 0; i < 26; i++) {
            if (curr.children[i] != null) {
                if (dfs(word, index + 1, curr.children[i])) {
                    return true;
                }
            }
        }
        return false;
    }
}

class TrieNode {
    TrieNode[] children = new TrieNode[26];
    boolean isEnd;
}
