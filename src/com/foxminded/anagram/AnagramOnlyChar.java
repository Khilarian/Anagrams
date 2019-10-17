/**
 * 
 * @author Kirill Rumakin
 * @since 16.20.2019
 * 
 * This class takes original text and reverses all the words of input text with following next rules:
 * All non-letter symbols should stay on the same places:
 * E.g. "a1bcd efg!h" => "d1cba hgf!e"
 *
 */

package com.foxminded.anagram;

import java.util.Arrays;
import java.util.List;

public class AnagramOnlyChar implements Operation{
	
	@Override
	public String handleText(Text text) {
		String[] words = text.getWordsArray();
		String[] result = new String[words.length];
		
		for (int i = 0; i < words.length; i++) {
			result[i] = handleWord(words[i]);
		}	
		return toString(result);
	}
	
	private String handleWord(String word) {
		StringBuilder sb = new StringBuilder();
		int indexLastLetter = word.length() -1 ; 	
		
		for (int i = 0; i< word.length(); i++) { 
			String currChar = String.valueOf(word.charAt(i));
			if (!Alphabet.ALPHABET.contains(currChar)) {			
				sb.append(currChar);
			}
			else 
			{
				String revChar = String.valueOf(word.charAt(indexLastLetter));
				if (Alphabet.ALPHABET.contains(revChar)) {   		
					sb.append(String.valueOf(word.charAt(indexLastLetter)));
					indexLastLetter--;
				}else {
					indexLastLetter = findLetterIndex(word,indexLastLetter);					 
					sb.append(word.charAt(indexLastLetter));
					indexLastLetter--;
				}			
			}
		}
		return sb.toString();
	}
	
	/*
	 * Helper method to find next letter.
	 * @return index of letter that placed before non-letter character in word.
	 */
	private int findLetterIndex(String word, int index) {
		int returnIndex = 0;
		for (int i = index; i >= 0; i--) {
			if (Alphabet.ALPHABET.contains(String.valueOf(word.charAt(i))) ) {
				returnIndex = i;
				break;
			}
		}
		return returnIndex;
	}
	
	
	/*
	 * 
	 * This class concatenate all words in array to one String.
	 * @param array. Input array of words
	 * @return mutation of original text. 
	 */ 
	private String toString(String [] array) {
	
		List<String> list = Arrays.asList(array);
		String result = String.join(" ", list);
		
		return result;
	}
}
