package jogoforca.core;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import jogoforca.game.GameException;
import jogoforca.utils.RandomUtils;

public class Dictionary {

	private static final String FILE_NAME = "dicionario.txt";

	//desingn pattern singleton

	private static Dictionary instance;

	private List<String> words = new ArrayList<>();

	private Dictionary() {
		load();
	}

	//desingn pattern singleton
	public static Dictionary getInstance() {
		if (instance == null) {
			instance = new Dictionary();
		}

		return instance;
	}

	private void load() {

		try (Scanner scan = 
				new Scanner(getClass().getResourceAsStream("/" + FILE_NAME))) {

			while (scan.hasNextLine()) {
				String word = scan.nextLine().trim();
				words.add(word);
			}

			if (words.size() == 0) {
				throw new GameException("A lista de palavras não pode ser vazia");
			}
		}
	}

	public Word nextWord() {
		int pos = RandomUtils.newRandomNumber(7, 12);
		return new Word(words.get(pos));
	}
}
