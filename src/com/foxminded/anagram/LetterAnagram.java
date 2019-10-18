package com.foxminded.anagram;

public class LetterAnagram {
	
    public String makeAnagram(String text) {
        String [] words = text.split(" +");
        String [] result = new String [words.length];
        for (int i = 0; i < result.length; i++) {
            result [i] = makeWordAnagram(words[i]);
        }	
        return String.join(" ", result);
    }
	

    private String makeWordAnagram(String word) {
        StringBuilder sb = new StringBuilder(word);
        int indexLastLetter = word.length() - 1;
        for(int i = 0; i < sb.length() && i < indexLastLetter; i++) {
            if (Character.isLetter(word.charAt(i))) {
                swap(sb, i, previousLetterIndex(word, indexLastLetter));
                indexLastLetter--;
            }
        }
        return sb.toString();
    }
    
    private void swap(StringBuilder word, int first, int second) {
        char temp = word.charAt(first);
        word.setCharAt(first, word.charAt(second));
        word.setCharAt(second, temp);    
    }
    
    private int previousLetterIndex(String word, int index) {
        for (int i = index; i >= 0; i--) {
            if (Character.isLetter(word.charAt(i)))  {
                return i;	
            }
        }
        return -1;
    }
}
    

 