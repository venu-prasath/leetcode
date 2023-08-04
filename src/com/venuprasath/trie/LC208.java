package com.venuprasath.trie;

public class LC208 {

    public static void main(String[] args) {
        Trie obj = new Trie();
        obj.insert("apple");
        boolean value1 = obj.search("apple");
        boolean value2 = obj.search("app");
        boolean value3 = obj.startsWith("app");

        System.out.println("value1: "+ value1 + ", value2: "+value2 + ", value3: "+value3);
    }
}

class Trie {
    private Trie children[];
    private boolean isEndOfWord;

    public Trie() {
        children = new Trie[26];
        isEndOfWord = false;
    }

    public void insert(String word) {
        Trie curr = this;
        for(char c: word.toCharArray()) {
            if((curr.children[c-'a']) == null) {
                curr.children[c-'a'] = new Trie();
            }
            curr = curr.children[c-'a'];
        }
        curr.isEndOfWord = true;
    }

    public boolean search(String word) {
        Trie curr = this;
        for(char c: word.toCharArray()) {
            curr = curr.children[c-'a'];
            if(curr == null) {
                return false;
            }
        }
        if(curr.isEndOfWord) return true;
        return false;
    }

    public boolean startsWith(String prefix) {
        Trie curr = this;
        for(char c: prefix.toCharArray()) {
            curr = curr.children[c-'a'];
            if(curr == null) {
                return false;
            }
        }
        return true;
    }
}
