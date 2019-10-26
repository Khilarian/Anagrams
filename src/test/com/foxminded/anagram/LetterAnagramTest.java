package test.com.foxminded.anagram;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import com.foxminded.anagram.LetterAnagram;

class LetterAnagramTest {
    
    LetterAnagram anagram;
    
    @BeforeEach
    void initialyzeAnagram() {
       anagram = new LetterAnagram();
    }
    
    @Nested
    class OnlyLetter{
        @Test
        void inputIsOneLetter() {
            String expected = "a";
            String actual = anagram.makeAnagram("a");
            assertEquals(expected, actual);
        }
        
        @Test
        void inputIsThreeLetter() {
            String expected = "abc";
            String actual = anagram.makeAnagram("cba");
            assertEquals(expected, actual);
        }
    }
    
    @Nested
    class OnlyNonLetter{
        @Test
        void inputIsEmptyString() {
            String expected = "";
            String actual = anagram.makeAnagram("");
            assertEquals(expected, actual);
        }
        
        @Test
        void inputIsOneNonLetter() {
            String expected = "1";
            String actual = anagram.makeAnagram("1");
            assertEquals(expected, actual);
        }
        
        @Test
        void inputIsThreeNonLetter() {
            String expected = ")!1";
            String actual = anagram.makeAnagram(")!1");
            assertEquals(expected, actual);
        }
        
        @Test
        void inputIsNull() {
            assertThrows(NullPointerException.class, () -> anagram.makeAnagram(null));
        }
    }
    
    @Nested
    class CombinedInput {
        @Test
        void inputIsOneLetterAndNonLetter() {
            String expected = "1a";
            String actual = anagram.makeAnagram("1a");
            assertEquals(expected, actual);
        }
        
        @Test
        void inputIsTwoLetterAndTwoNonLetter() {
            String expected = "a1b2";
            String actual = anagram.makeAnagram("b1a2");
            assertEquals(expected, actual);
        }
        
        @Test
        void inputIsSentence() {
            String expected = "world, hello!";
            String actual = anagram.makeAnagram("dlrow, olleh!");
            assertEquals(expected, actual);
        }
    }
}
