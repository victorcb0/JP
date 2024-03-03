package lab1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex3 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader( new InputStreamReader(System.in));
		System.out.print("n = ");
		int n = Integer.parseInt(reader.readLine());
		int count = 0;
		for(int i = 1; i <= n; i++)
		{
			if (n % i == 0)
			{
				System.out.print(i + " ");
				count++;
			}
		}
		System.out.println();
		if (count == 2)
			System.out.println("Numar prim");
	}

}
