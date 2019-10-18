package com.foxminded.anagram;

public class AppStarter {
	
	public static void main(String [] args) {
		String text = "h1111111ello , what1aa";
		LetterAnagram anagram = new LetterAnagram();		
		System.out.println(anagram.makeAnagram(text));
	}

}
