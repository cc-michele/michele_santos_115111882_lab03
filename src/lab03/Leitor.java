package lab03;

import java.util.Scanner;
/* 115111882 - Michele Santos Memoria Lab 03 - Turma 01 */
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
