/**
 * 
 * @author Kirill Rumakin
 * @since 16.10.2019
 *
 * This class mutate input text with one of provided methods.
 *
 */

package com.foxminded.anagram;

public class AppStarter {
	
	public static void main(String [] args) {
		Text text = new Text("hello, my brother from 2k19!");
		AnagramOnlyChar anagram = new AnagramOnlyChar();
			
		System.out.println(anagram.handleText(text));
	}

}
