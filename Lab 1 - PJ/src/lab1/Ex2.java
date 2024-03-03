package lab1;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;

public class Ex2 {

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new FileReader("in.txt"));
		int a, suma = 0, count = 0, min =  Integer.MAX_VALUE, max = Integer.MIN_VALUE;
		float media;
		String str;
		while((str = reader.readLine()) != null)
		{
			a = Integer.parseInt(str);
			suma += a;
			count++;
			if (min > a)
				min = a;
			if (max < a)
				max = a;
		}
		media = suma / count;
		System.out.println("Suma: " + suma);
		System.out.println("Media: " + media);
		System.out.println("Minim: " + min);
		System.out.println("Maxim: " + max);
		PrintStream writer = new PrintStream("out.txt");
		writer.println("Suma: " + suma);
		writer.println("Media: " + media);
		writer.println("Minim: " + min);
		writer.print("Maxim: " + max);
		writer.close();
	}

}
