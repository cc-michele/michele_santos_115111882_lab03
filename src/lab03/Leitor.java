package lab03;

import java.util.Scanner;

public class Leitor {

	public static Scanner input = new Scanner(System.in);

	public static int leInteiro() {

		int inteiro = input.nextInt();
		input.nextLine();
		return inteiro;

	}

	public static double leDouble() {

		double leDouble = input.nextDouble();
		return leDouble;

	}

	public static String leString() {
		String lendoString = input.nextLine();
		return lendoString;

	}

}
