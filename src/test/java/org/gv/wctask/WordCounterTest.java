package org.gv.wctask;

import java.io.IOException;
import java.util.Map;

import org.junit.Test;

import static org.junit.Assert.assertThat;
import static org.gv.wctask.TestUtils.stringToInputStream;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.collection.IsMapContaining.hasEntry;


public class WordCounterTest {

    @Test
    public void testBaseCase() throws IOException {
        WordCounter sut = new WordCounter(stringToInputStream("This is a statement, and so is this."));
        Map<String, Integer> res = sut.wordCount();
        assertThat(res, hasEntry("this", 2));
        assertThat(res, hasEntry("is", 2));
        assertThat(res, hasEntry("a", 1));
        assertThat(res, hasEntry("statement", 1));
        assertThat(res, hasEntry("and", 1));
        assertThat(res, hasEntry("so", 1));
    }

}
