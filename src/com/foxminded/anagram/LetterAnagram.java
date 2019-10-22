package com.foxminded.anagram;

public class LetterAnagram {
    
    public String makeAnagram(String text) {
        String[] words = text.split(" +");
        String[] result = new String[words.length];
        for (int i = 0; i < result.length; i++) {
            result[i] = makeWordAnagram(words[i]);
        }
        return String.join(" ", result);
    }
    
    private String makeWordAnagram(String inputWord) {
        char[] word = inputWord.toCharArray();
        for (int i = 0, j = inputWord.length(); i < word.length && i < j; i++) {
            if (Character.isLetter(inputWord.charAt(i))) {
                j = previousLetterIndex(inputWord, j);
                swap(word, i, j);
            }
        }
        return new String(word);
    }
    
    private void swap(char[] word, int first, int second) {
        char temp = word[first];
        word[first] = word[second];
        word[second] = temp;
    }
    
    private int previousLetterIndex(String word, int index) {
        for (int i = index - 1; i >= 0; i--) {
            if (Character.isLetter(word.charAt(i))) {
                return i;
            }
        }
        throw new IllegalArgumentException("No more letter in word");
    }
}
