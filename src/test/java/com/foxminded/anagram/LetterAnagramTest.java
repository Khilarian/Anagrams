package test.java.com.foxminded.anagram;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import main.java.com.foxminded.LetterAnagram;

class LetterAnagramTest {
    
    LetterAnagram anagram = new LetterAnagram();
    
    @Test
    void makeAnagramReturnEmptyStringWhenInputIsEmptyString() {
        String expected = "";
        String actual = anagram.makeAnagram("");
        assertEquals(expected, actual);
    }
        
    @Test
    void makeAnagramReturnOneSpaceWhenInputIsOneSpace() {
        String expected = " ";
        String actual = anagram.makeAnagram(" ");
        assertEquals(expected, actual);
    }
    
    @Test
    void makeAnagramReturnThreeSpaceWhenInputIsThreeSpace() {
        String expected = "   ";
        String actual = anagram.makeAnagram("   ");
        assertEquals(expected, actual);
    }
        
    @Test
    void makeAnagramReturnOneLetterWhenInputIsOneLetter() {
        String expected = "с";
        String actual = anagram.makeAnagram("с");
        assertEquals(expected, actual);
    }
        
    @Test
    void makeAnagramReturnThreeEqualsLetterWhenInputIsThreeEqualsLetter() {
        String expected = "ттт";
        String actual = anagram.makeAnagram("ттт");
        assertEquals(expected, actual);
    }
 
    @Test
    void makeAnagramReturnOneReversedWordInLowerCaseWhenInputIsOneWordInLowerCase() {
        String expected = "esac";
        String actual = anagram.makeAnagram("case");
        assertEquals(expected, actual);
    }
        
    @Test
    void makeAnagramReturnReversesWordWithDifferentCasesWheinInputIsWordWithDifferentCases() {
        String expected = "aaaAAa";
        String actual = anagram.makeAnagram("aAAaaa");
        assertEquals(expected, actual);
    }
        
    @Test
    void makeAnagramReturnNonLetterCharactersInSameOrderWhenInputIsNonLetterCharacters() {
        String expected = "}! ";
        String actual = anagram.makeAnagram("}! ");
        assertEquals(expected, actual);
    }
    
    @Test
    void makeAnagramReturnWordWithReversedLettersAndNonLettersOnOriginalPlacesWhenInputIsWordWithCombinedLetters() {
        String expected = "hy!fi)";
        String actual = anagram.makeAnagram("if!yh)");
        assertEquals(expected, actual);
    }
    
    @Test
    void makeAnagramReturnWordsInTheSamePositionWhereWordsAreReversedExceptNonLettersWhenInputIsSomeWords() {
        String expected = "It is a 1 of 8teen day!";
        String actual = anagram.makeAnagram("tI si a 1 fo 8neet yad!");
        assertEquals(expected, actual);
    }
}
