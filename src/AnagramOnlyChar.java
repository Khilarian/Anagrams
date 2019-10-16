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

public class AnagramOnlyChar implements Operation{

	//every operation has its own name that used in operation() method.
	@Override
	public String operation() {
		return "anagramsOnlyChar";
	}
	
	@Override
	public String handleText(Text text) {
		String[] wordsArray = text.getWordsArray();
		String[] returnArray = new String[wordsArray.length];
		
		for (int j = 0; j < wordsArray.length; j++) {
			String word = wordsArray[j];
			StringBuffer sb = new StringBuffer();
			
			int k = word.length() -1 ; 								
			/*index of last non-added char from tail of word.*/
			
			for (int i = 0; i< word.length(); i++) { 
				String currChar = String.valueOf(word.charAt(i));
				if (!Text.ALPHABET.contains(currChar)) {			
					/*if character from head is not letter, put it in new word.*/
					sb.append(currChar);
				}
				else 
				{
					String revChar = String.valueOf(word.charAt(k));
					if (Text.ALPHABET.contains(revChar)) {   		
						/*if both character from head and tail is letter, add char from tail.*/
						sb.append(String.valueOf(word.charAt(k)));
						k--;
					}else {
						/*if character from head is letter and character from tail word is not,
						 *  add first letter from tail before non-letter character.
						 */
						k = findCharIndex(word,k);					 
						sb.append(word.charAt(k));
						k--;
					}			
				}
			}
			returnArray[j] = sb.toString();
		}	
		return toString(returnArray);
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
		StringBuilder returnString = new StringBuilder();
		for (int i = 0; i < array.length; i++) {
			returnString.append(array[i]);
			returnString.append(" ");
		}
		return returnString.toString().trim();
	}
	
}