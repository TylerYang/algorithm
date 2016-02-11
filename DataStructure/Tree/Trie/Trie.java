public class Trie{ 
    TrieNode root;
    public Trie() {
        root = new TrieNode(); 
    }
    private void insert(String str) {
        TrieNode node = root;
        for(int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            int idx = c - 'a';
            if(node.letters[idx] == null) {
                node.letters[idx] = new TrieNode();
            }
            node = node.letters[idx];
        }
    }
    private boolean search(String str) {
        TrieNode node = root;
        for(int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            int idx = c - 'a';
            if(node.letters[idx] == null) return false;
            node = node.letters[idx]; 
        }
        return node.isEnd;
    }
    private boolean startWith(String prefix) {
        TrieNode node = root;
        for(int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            int idx = c - 'a';
            if(node.letters[idx] == null) return false;
            node = node.letters[idx]; 
        }
        return true;
    }
}
