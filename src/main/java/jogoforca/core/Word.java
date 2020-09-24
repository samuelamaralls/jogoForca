package jogoforca.core;

import java.util.HashSet;
import java.util.Set;

public class Word {

	private static final char SECRET_CHAR = '_';

	private String originalWord;
	private Set<Character> foundChars = new HashSet<>();
	private Set<Character> wordChars = new HashSet<>();

	public Word(String originalWord) {
		this.originalWord = originalWord.toUpperCase();

		char[] chars = this.originalWord.toCharArray();
		for (char c : chars) {
			wordChars.add(c);
		}
	}

	public int size() {
		return originalWord.length();
	}

	public boolean hasChar(char c) {
		c = Character.toUpperCase(c);
		if (originalWord.indexOf(c) > -1) {
			foundChars.add(c);
			return true;
		}

		return false;
	}

	public String toString() {
		// metodo de concatenacao de strings
		StringBuilder sb = new StringBuilder();

		// transforma a string em um array de caracteres
		char[] charArray = originalWord.toCharArray();

		for (int i = 0; i < charArray.length; i++) {
			char c = charArray[i];

			if (foundChars.contains(c)) {
				sb.append(c);
			} else {
				sb.append(SECRET_CHAR);
			}

			sb.append(" ");
		}

		return sb.toString();
	}

	public String getOriginalWord() {
		return originalWord;
	}
	
	public boolean discovered() {
		return foundChars.equals(wordChars);		
	}
	
}
