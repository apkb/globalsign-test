package org.globalsign.test;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class FileWordCountAppTest {
	
	@Test
	public void giveninputFile_when_getMostFreqWordsiscalled_thenreturn20mostfrequentwords(){
		FileWordCountApp app = new FileWordCountApp();
		WordCountPair[] wcPair = app.getMostFreqWords(20, "mobydick.txt");
		assertTrue(wcPair.length==20);
		for(int i=0;i<wcPair.length-1;i++) {
			assertTrue(wcPair[i].getCount()>=wcPair[i+1].getCount());
		}
	}
}
