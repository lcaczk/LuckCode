package com.wkk.backtrack;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @Time: 20-3-25下午4:51
 * @Author: kongwiki
 * @Email: kongwiki@163.com
 */
public class IteratorForCombination {
    private List<List<Character>> results = new ArrayList<>();
    private List<Character> out = new LinkedList<>();
    private String characters;
    private int combinationLength;
    public IteratorForCombination(String characters, int combinationLength){
        this.characters = characters;
        this.combinationLength = combinationLength;
        backtrack(characters, out, combinationLength);
    }

    private void backtrack(String characters, List<Character> list, int combinationLength){
        if(list.size() == combinationLength){
            results.add(new ArrayList<>(list));
        }
        for (int i = 0; i < characters.length(); i++) {
            if(list.contains(characters.charAt(i))){
                continue;
            }
            list.add(characters.charAt(i));
            list.remove(list.size()-1);

        }
    }

    public String next() {
        if(hasNext()){
            List<Character> characters = results.get(0);
            results.remove(0);
            String s = characters.toString();
            return s;
        }
        return null;

    }

    public boolean hasNext() {
        return !results.isEmpty();
    }
}
