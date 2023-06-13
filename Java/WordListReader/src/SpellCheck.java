import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;
import java.io.File;
import java.io.FileNotFoundException;

/**
 * This program checks which words in a file are not present in a dictionary.
 */
public class SpellCheck {
	public static void main(String[] args) throws FileNotFoundException {
		// Read the dictionary and the document

		Set<String> dictionaryWords = readWordsHashSet("resources/words");
		Set<String> documentWords = readWordsHashSet("resources/alice30.txt");

		// Print all words that are in the document but not the dictionary
		System.out.println("~~~~~~First Data Set~~~~~~~~");
		for (String word : documentWords) {
			if (!dictionaryWords.contains(word)) {
				System.out.println(word);
			}
		}
		
		
		documentWords.clear();
		dictionaryWords.clear();
		System.out.println("\n\n\n");
		
		dictionaryWords = readWordsTreeSet("resources/words");
		documentWords = readWordsTreeSet("resources/secondDataSet.txt");

		// Print all words that are in the document but not the dictionary
		System.out.println("~~~~~~Second Data Set~~~~~~~~");
		for (String word : documentWords) {
			if (!dictionaryWords.contains(word)) {
				System.out.println(word);
			}
		}
		
		System.out.println("\n\n\n");
		
		System.out.println("~~~~~Starting Read HashSet Test~~~~~~~"); 
		long hashSetTime;  
		StopWatch timer = new StopWatch();
		
		timer.start();
		List<String>  wordsList = readWordsArrayList("resources/war-and-peace.txt");
		timer.stop();
		hashSetTime = timer.getElapsedTime();
		timer.reset();
		System.out.println("Elapsed time for ArrayList "
		+ hashSetTime + " milliseconds.  Number of words: " + wordsList.size());

		
		timer.start();
		Set<String> words = readWordsHashSet("./resources/war-and-peace.txt");
		timer.stop();
		hashSetTime = timer.getElapsedTime();
		timer.reset();
		System.out.println("Elapsed time for HashSet "
		+ hashSetTime + " milliseconds.  Number of words: " + words.size());
		words.clear();
		
		timer.start();
		words = readWordsTreeSet("./resources/war-and-peace.txt");
		timer.stop();
		hashSetTime = timer.getElapsedTime();
		timer.reset();
		System.out.println("Elapsed time for TreeSet "
		+ hashSetTime + " milliseconds.  Number of words: " + words.size());
	}

	/**
	 * Reads all words from a file.
	 * 
	 * @param filename the name of the file
	 * @return a set with all lowercased words in the file. Here, a word is a
	 *         sequence of upper- and lowercase letters.
	 */
	public static Set<String> readWordsHashSet(String filename) throws FileNotFoundException {
		Set<String> words = new HashSet<>();
		Scanner in = new Scanner(new File(filename));
		// Use any characters other than a-z or A-Z as delimiters
		in.useDelimiter("[^a-zA-Z]+");
		while (in.hasNext()) {
			words.add(in.next().toLowerCase());
		}
		return words;
	}

	public static List<String> readWordsArrayList(String filename) throws FileNotFoundException {
		List<String> words = new ArrayList<>();
		Scanner in = new Scanner(new File(filename));
		// Use any characters other than a-z or A-Z as delimiters
		in.useDelimiter("[^a-zA-Z]+");
		while (in.hasNext()) {
			words.add(in.next().toLowerCase());
		}
		return words;
	}

	public static Set<String> readWordsTreeSet(String filename) throws FileNotFoundException {
		Set<String> words = new TreeSet<>();
		Scanner in = new Scanner(new File(filename));
		// Use any characters other than a-z or A-Z as delimiters
		in.useDelimiter("[^a-zA-Z]+");
		while (in.hasNext()) {
			words.add(in.next().toLowerCase());
		}
		return words;
	}
}
