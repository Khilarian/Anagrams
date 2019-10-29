package main.java.com.foxminded;

import java.util.ArrayList;

public class LetterAnagram {
    
    public String makeAnagram(String text) {
        ArrayList<String> words = new ArrayList<String>();
        for (int i = 0, j = 0; i < text.length(); i = j + 1) {
            j = text.indexOf(' ', i);
            if (j != -1) {
                words.add(makeWordAnagram(text.substring(i, j + 1)));
            } else {
                words.add(makeWordAnagram(text.substring(i, text.length())));
                break;
            }             
        }
        return String.join("", words);
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
        throw new IllegalArgumentException("Invalid first argument: 'word' -> " + word +", the argument must contain at least one letter.");
    }
}
