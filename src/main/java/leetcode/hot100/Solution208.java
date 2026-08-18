package leetcode.hot100;

public class Solution208 {

    class Trie {

        class TrieNode {
            // 子树
            TrieNode[] children = new TrieNode[26];
            // 是否是末尾字符
            boolean end;
        }

        private final TrieNode root;

        public Trie() {
            root = new TrieNode();
        }

        public void insert(String word) {
            TrieNode cur = root;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                if (cur.children[c - 'a'] == null) {
                    cur.children[c - 'a'] = new TrieNode();
                }
                cur = cur.children[c - 'a'];
            }
            cur.end = true;
        }

        public boolean search(String word) {
            TrieNode node = findPrefixNode(word);
            return node != null && node.end;
        }

        public boolean startsWith(String prefix) {
            return findPrefixNode(prefix) != null;
        }

        /**
         *
         * @param prefix 前缀
         * @return 返回该前缀的最后一个节点对应的字符
         */
        private TrieNode findPrefixNode(String prefix) {
            TrieNode cur = root;
            for (char c : prefix.toCharArray()) {
                if (cur.children[c - 'a'] == null) {
                    return null;
                }
                cur = cur.children[c - 'a'];
            }
            return cur;
        }
    }

}
