package com.foxminded.anagram;

public class AppStarter {
	
	public static void main(String [] args) {
		String text = "hello, my brother from 2k19!!";
		LetterAnagram anagram = new LetterAnagram();		
		System.out.println(anagram.makeAnagram(text));
	}

}
