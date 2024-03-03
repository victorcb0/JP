package lab1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex1 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("a = ");
		int a = Integer.parseInt(reader.readLine());
		System.out.print("b = ");
		int b = Integer.parseInt(reader.readLine());
		System.out.println("Perimetru = " + (a + b) * 2);
		System.out.println("Aria = " + (a * b));
	}

}
