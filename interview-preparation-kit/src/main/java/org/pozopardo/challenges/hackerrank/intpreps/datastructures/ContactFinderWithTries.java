package org.pozopardo.challenges.hackerrank.intpreps.datastructures;

import java.util.HashMap;
import java.util.Map;

public class ContactFinderWithTries {
    private final TrieNode root = new TrieNode();

    public void add(String name) {
        TrieNode currentNode = root;
        for(char c : name.toCharArray()) {
            currentNode.putChildIfAbsent(c);
            currentNode = currentNode.getChild(c);
            currentNode.increaseOccurrences();
        }
    }

    public int find(String partial) {
        TrieNode currentNode = root;

        for(char c : partial.toCharArray()) {
            currentNode = currentNode.getChild(c);
            if(currentNode == null) {
                return 0;
            }
        }
        return currentNode.occurrences();
    }

}

class TrieNode {
    Map<Character, TrieNode> children = new HashMap<>();
    private int occurrences = 0;

    public void putChildIfAbsent(char c) {
        children.putIfAbsent(c, new TrieNode());
    }

    public void increaseOccurrences() {
        occurrences++;
    }

    public int occurrences() {
        return occurrences;
    }

    public TrieNode getChild(char c) {
        return children.get(c);
    }
}
