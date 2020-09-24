package jogoforca.game;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import jogoforca.core.Config;
import jogoforca.core.Dictionary;
import jogoforca.core.InvalidCharacterException;
import jogoforca.core.Word;
import jogoforca.ui.UI;

public class Game {

	Scanner scan = new Scanner(System.in);

	int opcao = 0;
	
	public void start() {

		UI.print("Bem Vindo ao Jogo da Forca!");

		Dictionary dictionary = Dictionary.getInstance();
		Word word = dictionary.nextWord();

		UI.print("A palavra tem " + word.size() + " letras");

		Set<Character> usedChars = new HashSet<>();
		int errorCount = 0;
		
		int maxErrors = Integer.parseInt(Config.get("maxErrors"));
		UI.print("Voce pode errar no maximo " + maxErrors + " vez(es)");


		while (true) {
			UI.print(word);
			UI.printNewLine();

			char c;
			try {
				c = UI.readChar("Digite uma letra:");

				if (usedChars.contains(c)) {
					throw new InvalidCharacterException("Esta letra já foi utilizada");
				}

				usedChars.add(c);

				if (word.hasChar(c)) {
					UI.print("Você acertou uma letra!");

				} else {
					errorCount++;

					if (errorCount < maxErrors) {
						UI.print("Você errou! Você ainda pode errar " + (maxErrors - errorCount) + " vez(es)");
					}
				}

				UI.printNewLine();

				if (word.discovered()) {
					UI.print("PARABÉNS! Você acertou a palavra correta: " + word.getOriginalWord());
					UI.print("Fim do Jogo!");
					break;
				}

				if (errorCount == maxErrors) {
					UI.print("Você perdeu o jogo! A palavra correta era: " + word.getOriginalWord());
					UI.print("Fim do Jogo!");
					break;
				}

			} catch (InvalidCharacterException e) {
				UI.print("Erro: " + e.getMessage());
				UI.printNewLine();
			}
		}
	}
}