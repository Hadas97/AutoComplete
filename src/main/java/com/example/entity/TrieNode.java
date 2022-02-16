package com.example.entity;

import java.util.HashMap;
import java.util.Map;

import com.example.entity.TrieNode;

import lombok.Data;

@Data
public class TrieNode {
        Map<Character, TrieNode> children;
        char letter;
        boolean endOfWord;
 
        public TrieNode(char letter) {
            this.letter = letter;
            children = new HashMap<>();
        }
 
        public TrieNode() {
            children = new HashMap<>();
        }
 
        public void insert(String word) {
            if (word == null || word.isEmpty())
                return;
            char firstChar = word.charAt(0);
            TrieNode child = children.get(firstChar);
            if (child == null) {
                child = new TrieNode(firstChar);
                children.put(firstChar, child);
            }
 
            if (word.length() > 1)
                child.insert(word.substring(1));
            else
                child.endOfWord = true;
        }

}
