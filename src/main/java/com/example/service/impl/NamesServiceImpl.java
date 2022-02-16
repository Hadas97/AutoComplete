package com.example.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.entity.NameEntity;
import com.example.entity.TrieNode;
import com.example.repository.NamesRepository;
import com.example.service.NamesService;


@Component
public class NamesServiceImpl implements NamesService{
	
	@Autowired  
	private NamesRepository namesRepository; 

	@Override
	public List<String> getNamesSuggestions(String prefix) {
		List<NameEntity> names = namesRepository.findAll();
		
		TrieNode root = new TrieNode();
        for (NameEntity name : names)
            insert(root, name.getName());
        return suggest(root, prefix);
	}
	
	private void insert(TrieNode root, String word) {
            if (word == null || word.isEmpty())
                return;
            char firstChar = word.charAt(0);
            TrieNode child = root.getChildren().get(firstChar);
            if (child == null) {
                child = new TrieNode(firstChar);
                root.getChildren().put(firstChar, child);
            }
 
            if (word.length() > 1)
                child.insert(word.substring(1));
            else
                child.setEndOfWord(true);
    }
	

	private void suggestHelper(TrieNode root, List<String> list, StringBuilder curr) {
        if (root.isEndOfWord()) {
            list.add(curr.toString());
        }
 
        if (root.getChildren() == null || root.getChildren().isEmpty())
            return;
 
        for (TrieNode child : root.getChildren().values()) {
            suggestHelper(child, list, curr.append(child.getLetter()));
            curr.setLength(curr.length() - 1);
        }
    }
	
    private List<String> suggest(TrieNode root, String prefix) {
        List<String> list = new ArrayList<>();
        TrieNode lastNode = root;
        StringBuilder curr = new StringBuilder();
        for (char c : prefix.toCharArray()) {
//        	Character.toUpperCase(c) || Character.toLowerCase(c)
            lastNode = lastNode.getChildren().get(c);
            if (lastNode == null)
                return list;
            curr.append(c);
        }
        suggestHelper(lastNode, list, curr);
        return list;
    }

}
