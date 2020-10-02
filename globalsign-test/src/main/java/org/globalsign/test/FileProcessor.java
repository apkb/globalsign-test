package org.globalsign.test;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class FileProcessor {

	public static Map<String, Integer> getFileWordsWithFrequency(String filename) {
		TreeMap<String, Integer> wordcountMap = new TreeMap<String, Integer>();
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(filename)));
			String line;
			while ((line = br.readLine()) != null) {
				if (line.isEmpty()) {
					continue;
				}
				String[] words = line.split("[^a-zA-Z]");
				for (int i = 0; i < words.length; i++) {
					if (!words[i].isEmpty()) {
						words[i] = words[i].toLowerCase();
						if (wordcountMap.containsKey(words[i])) { // store each word with its freq in treemap
							wordcountMap.put(words[i], wordcountMap.get(words[i]) + 1);
						} else {
							wordcountMap.put(words[i], 1);
						}
					}
				}
			}
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return wordcountMap;
	}

	public static WordCountPair[] getWordCountSortedByCount(int k, Map<String, Integer> wordcountmap) {
		WordCountPair[] arr = new WordCountPair[wordcountmap.size()];
		int i = 0;
		for (String key : wordcountmap.keySet()) {
			arr[i] = new WordCountPair(key, wordcountmap.get(key));
			i++;
		}
		Arrays.sort(arr); // sorting based on frequency from highest to lowest
		WordCountPair[] out = new WordCountPair[k];
		for (int j = 0; j < k; j++) {
			out[j] = arr[j];
		}
		return out;
	}

}
