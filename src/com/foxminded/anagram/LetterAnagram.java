package com.foxminded.anagram;

import java.util.Arrays;
import java.util.List;

public class LetterAnagram {
	
	public String makeAnagram(String text) {
		String[] words = text.split(" +");
		String[] result = new String[words.length];	
		for (int i = 0; i < words.length; i++) {
			result[i] = handleWord(words[i]);
		}	
		return toString(result);
	}
	
	private String handleWord(String word) {
		StringBuilder sb = new StringBuilder();
		int indexLastLetter = word.length() - 1; 	
		
		for (int i = 0; i < word.length(); i++) { 
			char currChar = word.charAt(i);
			if (!Character.isLetter(currChar)) {			
				sb.append(currChar);
			}
			else {
				char revChar = word.charAt(indexLastLetter);
				if (Character.isLetter(revChar)) {   		
					sb.append(String.valueOf(word.charAt(indexLastLetter)));
					indexLastLetter--;
				}
				else {
					indexLastLetter = findLetterIndex(word, indexLastLetter);					 
					sb.append(word.charAt(indexLastLetter));
					indexLastLetter--;
				}			
			}
		}
		return sb.toString();
	}
	

	private int findLetterIndex(String word, int index) {
		int returnIndex = 0;
		for (int i = index; i >= 0; i--) {
			if (Character.isLetter(word.charAt(i)))  {
				returnIndex = i;
				break;
			}
		}
		return returnIndex;
	}
	
	
	private String toString(String [] array) {
		List<String> list = Arrays.asList(array);
		String result = String.join(" ", list);	
		return result;
	}
}