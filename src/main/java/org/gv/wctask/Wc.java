package org.gv.wctask;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

public class Wc {

    /* Main program, takes input from stdin, or a file name specified as the first parameter.
     * 
     */
    public static void main(String[] args) throws IOException {
        InputStream is;
        if (args.length == 0) {
            is = System.in;
        } else {
            is = new FileInputStream(args[0]);
        }
        
        WordCounter wc = new WordCounter(is);
        Map<String, Integer> wordCounts = wc.wordCount();
        wordCounts.forEach((k, v) -> System.out.println(k + " - " + v));
    }
    
}
