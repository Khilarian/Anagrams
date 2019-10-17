/**
 * 
 * @author Kirill Rumakin
 * @since 16.10.2019
 * 
 * Class represents input text as a array of words.
 * Also it stores alphabet that used to determine is character is letter.
 *
 */

package com.foxminded.anagram;

public class Text {
	
	private final String inputString;
	private final String [] words;
	
	public Text(String text) {
		inputString = text;
		words = splitText(text);
	}
	
	public String getInputString() {
		return inputString;
	}
	
	public String [] getWordsArray() {
		return words; 
	}
	
	private String [] splitText(String text) {
		return text.split(" +");
	}
	
	/*
	 * is it a good idea to add array of spaces to have mutation text with original spaces between words? 
	 */
	
}
