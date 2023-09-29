package com.venuprasath.trie;

public class LC211 {

    public static void main(String[] args) {
        WordDictionary dic = new WordDictionary();
        dic.addWord("apple");
        boolean param2 = dic.search("apple");
    }


}

class Triee {
    Triee children[] = new Triee[26];
    boolean isEndOfWord;
}

class WordDictionary {
    Triee trie;

    public WordDictionary() {
        trie = new Triee();
        trie.isEndOfWord = false;
    }

    public void addWord(String word) {
        Triee curr = trie;
        for(char c: word.toCharArray()) {
            if((curr.children[c-'a']) == null) {
                curr.children[c-'a'] = new Triee();
            }
            curr = curr.children[c-'a'];
        }
        curr.isEndOfWord = true;
    }

    public boolean search(String word) {
        Triee curr = trie;
        return searchHelper(curr, word, 0);
    }

    private boolean searchHelper(Triee node, String word, int index) {
        if(index == word.length()) {
            return node.isEndOfWord;
        }
        char ch = word.charAt(index);
        if(ch == '.') {
            for(int i=0; i<26; i++) {
                if(node.children[i] != null &&
                        (searchHelper(node.children[i], word, index+1))) {
                    return true;
                }
            }
            return false;
        } else {
            if(node.children[ch-'a'] != null) {
                return searchHelper(node.children[ch-'a'], word, index+1);
            } else {
                return false;
            }
        }
    }
}