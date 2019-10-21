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
        char[] sb = word.toCharArray();
        for(int i = 0, j =word.length() -1; i < sb.length && i < j; i++) {
            if (Character.isLetter(word.charAt(i))) {
                swap(sb, i, previousLetterIndex(word, j));
                j--;
            }
        }
        return new String(sb);
    }
    
    private void swap(char[] word, int first, int second) {
        char temp = word[first];
        word[first] = word[second];
        word[second] = temp;;    
    }
    
    private int previousLetterIndex(String word, int index) {
        for (int i = index; i >= 0; i--) {
            if (Character.isLetter(word.charAt(i)))  {
                return i;	
            }
        }
        throw new IllegalArgumentException("No such index.");
    }
}
    

 