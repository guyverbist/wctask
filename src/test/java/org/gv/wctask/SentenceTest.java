package org.gv.wctask;

import java.io.IOException;

import org.junit.Test;

import static org.gv.wctask.TestUtils.stringToInputStream;
import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.hasItems;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.collection.IsEmptyCollection.empty; 

public class SentenceTest {
	
    @Test
    public void handlesStandardSentence() throws IOException {
        assertInputAndOutput("two words.", "two", "words");
    }
    
    @Test
    public void lowerCases() throws IOException {
        assertInputAndOutput("Two words.", "two", "words");
    }
    
    @Test
    public void handlesTrailingWords() throws IOException {
        assertInputAndOutput("Two words. And some more words", "two", "words");
    }
    
    @Test
    public void terminatesWithExclamationMark() throws IOException {
        assertInputAndOutput("Two words! And some more words", "two", "words");
    }
    
    @Test
    public void terminatesWithQuestionMark() throws IOException {
        assertInputAndOutput("Two words? And some more words", "two", "words");
    }

    @Test
    public void handlesNoTerminator() throws IOException {
        assertInputAndOutput("Two words", "two", "words");
    }
    
    @Test
    public void handlesEmptySentence() throws IOException {
        Sentence s = new Sentence(stringToInputStream(""));
        assertThat(s.words(), is(empty()));
    }
    
    @Test
    public void handlesNull() throws IOException {
        Sentence s = new Sentence(null);
        assertThat(s.words(), is(empty()));
    }
    
    @Test
    public void doesNotBreakOnApostrophe() throws IOException {
        assertInputAndOutput("Here's three words", "here's", "three", "words");
    }
    
	private void assertInputAndOutput(String input, String ... expected) throws IOException {
        Sentence s = new Sentence(stringToInputStream(input));
	    assertThat(s.words(), hasItems(expected));
	}

}
