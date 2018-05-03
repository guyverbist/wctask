package org.gv.wctask;

import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;

import static com.google.common.collect.Lists.newArrayList;

public class Sentence {
	
	private final List<String> words;
	
	public Sentence(InputStream is) throws IOException {
		String firstSentence = firstSentence(is);
		if (firstSentence == null) {
			words = newArrayList();
			return;
		}
		
		words = decomposeSentence(firstSentence);
	}
	
	public List<String> words() {
	    return words;
	}
	
	// Decomposes into lowercase "words"
	// Only handles ASCII (non-accented characters)
	// Deems apostrophes not to be word boundaries
	// Tweaking regex would solve / alter the above
	private static List<String> decomposeSentence(String s) {
	    String words[] = s.split("[\\W&&[^']]+");
	    return Arrays.stream(words)
	          .filter(word -> !StringUtils.isBlank(word))
	          .map(nonBlankWord -> nonBlankWord.toLowerCase())
	          .collect(Collectors.toList());
	}
	
	// Returns the first "sentence" i.e. something terminated by one of three punctuation marks, or simply the end of the stream
	private static String firstSentence(InputStream is) throws IOException {
	    if (is == null) {
	        return null;
	    }
	    
		StringWriter writer = new StringWriter();
		IOUtils.copy(is, writer, StandardCharsets.UTF_8);
		String theString = writer.toString();
		String[] sentences = theString.split("[.?!]");

		if (sentences.length == 0) {
			return null;
		}
		
		return sentences[0];
	}

}
