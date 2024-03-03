package lab3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Ex3 {

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new FileReader("judete_in.txt"));
		BufferedReader reader1 = new BufferedReader(new InputStreamReader(System.in));
		String str, judet;
		String[] sir = new String[10];
		int count = 0;
		while((str = reader.readLine()) != null)
		{
			sir[count] = str;
			count++;
		}
		Arrays.sort(sir);
		for(int i = 0; i < count; i++)
		{
			System.out.println(sir[i]);
		}
		System.out.print("\nJudet: ");
		judet = reader1.readLine();
		System.out.println(Arrays.binarySearch(sir, judet));
	}

}
