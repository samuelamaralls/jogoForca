package jogoforca.ui;

import java.util.Scanner;

import jogoforca.core.InvalidCharacterException;

public class UI {

	public static void print(Object object) {
		System.out.println(object);
	}

	public static void printNewLine() {
		System.out.println();
	}

	@SuppressWarnings("resource")
	public static char readChar(String text) throws InvalidCharacterException{
		System.out.println(text + " ");

		Scanner scan = new Scanner(System.in);
		String line = scan.nextLine();

		// trim() tira todos os espa�os em branco
		if (line.trim().isEmpty()) {
			throw new InvalidCharacterException("Nenhuma letra foi digitada!");
		}

		if (line.length() > 1) {
			throw new InvalidCharacterException("Apenas uma letra deve ser digitada!");
		}

		char c = line.charAt(0);

		// classe character = metodo isLetter retorna true se for uma letra
		if (!Character.isLetter(c)) {
			throw new InvalidCharacterException("Apenas uma letra deve ser digitada!");
		}
		
		return c;
	}
}
