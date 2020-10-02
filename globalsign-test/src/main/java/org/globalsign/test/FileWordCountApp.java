package org.globalsign.test;

import java.util.Map;

public class FileWordCountApp {
	public WordCountPair[] getMostFreqWords(int k, String filename) {
		Map<String, Integer> wcMap = FileProcessor.getFileWordsWithFrequency("src/main/resources/" + filename);
		// System.out.println(wcMap);
		System.out.println("Total words in the file "+filename+"=  " + wcMap.size());
		WordCountPair[] wordcountpair = FileProcessor.getWordCountSortedByCount(k, wcMap);
		return wordcountpair;

	}

	public static void main(String[] args) {
		FileWordCountApp app = new FileWordCountApp();
		WordCountPair[] wordcount = app.getMostFreqWords(20, "mobydick.txt");
		//WordCountPair[] wordcount = app.getMostFreqWords(20, "mobydickbin.dat");
		// Print top 20
		for (int j = 0; j < 20; j++) {
			System.out.println(wordcount[j].getWord() + ":" + wordcount[j].getCount());
		}

	}
}
