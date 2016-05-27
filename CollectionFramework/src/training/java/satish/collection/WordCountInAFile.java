package training.java.satish.collection;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class WordCountInAFile {

	public static void main(String[] args) throws FileNotFoundException, IOException {

		TreeMap<String, Integer> wordsWithCount = new TreeMap<String, Integer>();

		// read file (TextData in src folder)
		BufferedReader bufferdReader = new BufferedReader(new FileReader("src/TextData"));
		
		//this for read each line and store this variable
		String line = null;

		try {
			while ((line = bufferdReader.readLine()) != null) {
				String[] words = line.split("[ \n\t.,;:!?(){}]"); //split either one of character exists in line

				//here find each split word exist in TreeMap,then increment count. Otherwise add to TreeMap with count 1
				for (int wordCounter = 0; wordCounter < words.length; wordCounter++) {
					String key = words[wordCounter];

					if (key.length() > 0) {
						if (wordsWithCount.get(key) == null) {
							wordsWithCount.put(key, 1);
						} else {
							int value = wordsWithCount.get(key).intValue();
							value++;
							wordsWithCount.put(key, value);
						}
					}
				}
			}
		} catch (Exception e) {

		}
		
		//NOW PRINT HERE
		System.out.println("The word counts ....");
		System.out.println("--------------------");
		for(Map.Entry<String,Integer> entry : wordsWithCount.entrySet())
		{
			String word=entry.getKey();
			int wordsCount=entry.getValue();
			System.out.println(word +"== "+wordsCount);
		}
	}
}
