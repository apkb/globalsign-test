package org.globalsign.test;

//Wrapper class for word and its frequency count. implements Comparable to sort based onfrequency count
public class WordCountPair implements Comparable<WordCountPair>{
    private String word;
    private int count;

    public WordCountPair(String word, int count) {
        super();
        this.word = word;
        this.count = count;
    }

    public int compareTo(WordCountPair o) {
        int diff = o.count - this.count;
        return diff;
    }

	public String getWord() {
		return word;
	}

	public int getCount() {
		return count;
	}
    
    
}
