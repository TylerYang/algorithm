public class TrieNode {
    boolean isEnd;
    TrieNode[] letters;
    public TrieNode() {
        letters = new TrieNode[26];
        isEnd = false;
    }
}
