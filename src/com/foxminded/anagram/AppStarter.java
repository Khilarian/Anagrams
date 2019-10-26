package com.foxminded.anagram;

public class AppStarter {
	
	public static void main(String [] args) {
		String text = null;
		LetterAnagram anagram = new LetterAnagram();		
		System.out.println(anagram.makeAnagram(text));
	}

}
