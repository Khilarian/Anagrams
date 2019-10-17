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

	//every operation has its own name that used in operation() method.
	@Override
	public String operation() {
		return "anagramsOnlyChar";
	}
	
	@Override
	public String handleText(Text text) {
		String[] words = text.getWordsArray();
		String[] result = new String[words.length];
		
		for (int j = 0; j < words.length; j++) {
			String word = words[j];
			StringBuilder sb = new StringBuilder();
			
			int indexLastLetter = word.length() -1 ; 								
			/*index of last non-added char from tail of word.*/
			
			for (int i = 0; i< word.length(); i++) { 
				String currChar = String.valueOf(word.charAt(i));
				if (!Text.ALPHABET.contains(currChar)) {			
					/*if character from head is not letter, put it in new word.*/
					sb.append(currChar);
				}
				else 
				{
					String revChar = String.valueOf(word.charAt(indexLastLetter));
					if (Text.ALPHABET.contains(revChar)) {   		
						/*if both character from head and tail is letter, add char from tail.*/
						sb.append(String.valueOf(word.charAt(indexLastLetter)));
						indexLastLetter--;
					}else {
						/*if character from head is letter and character from tail word is not,
						 *  add first letter from tail before non-letter character.
						 */
						indexLastLetter = findCharIndex(word,indexLastLetter);					 
						sb.append(word.charAt(indexLastLetter));
						indexLastLetter--;
					}			
				}
			}
			result[j] = sb.toString();
		}	
		return toString(result);
	}
	
	/*
	 * Helper method to find next letter.
	 * @return index of letter that placed before non-letter character in word.
	 */
	private int findCharIndex(String word, int index) {
		int returnIndex = 0;
		for (int i = index; i >= 0; i--) {
			if (Text.ALPHABET.contains(String.valueOf(word.charAt(i))) ) {
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
