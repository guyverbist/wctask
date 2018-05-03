package org.gv.wctask;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

import static com.google.common.collect.Maps.newLinkedHashMap;


public class WordCounter {
    
    private final Sentence sentence;
    
    public WordCounter(InputStream is) throws IOException {
        sentence = new Sentence(is);
    }
    
    public Map<String, Integer> wordCount() {
        
        Map<String, Integer> res = newLinkedHashMap();
        
        sentence.words().forEach(s -> {
            res.compute(s, (k, v) -> v == null ? 1 : v + 1);
        });
        
        return res;
    }

}
