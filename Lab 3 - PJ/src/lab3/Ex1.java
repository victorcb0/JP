package lab3;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.Random;

class Vers {
	private String sir;
	public Vers(String sir)
	{
		this.sir = sir;
	}
	public int Nr_cuvinte()
	{
		String [] sir2 = sir.split(" ");
		return sir2.length;
	}
	public int Nr_vocale()
	{
		int count = 0;
		String sir2 = "aeiou";
		for(int i = 0; i < sir.length(); i++)
		{
			/*for(int j = 0; j < sir2.length(); j++)
			{
				if (sir.charAt(i) == sir2.charAt(j))
					
			}*/
			if (sir2.indexOf(sir.charAt(i)) >= 0)
				count++;
		}
		return count;
	}
	public int Cuvant_final(String sir3) 
	{
		int val = 0;
		String [] sir2 = sir.split(" ");
		if (sir2[sir2.length - 1].equals(sir3))
			val = 1;
		return val;
	}
	public String Majuscule()
	{
		if (Math.random() < 0.1)
			return sir.toUpperCase();
		else
			return sir;
	}
}

public class Ex1 {

	public static void main(String[] args) throws IOException {
		//Vers sir = new Vers("a b c d e e");
		//System.out.println(sir.cuvant_final("e"));
		String sir, sir2;
		BufferedReader reader = new BufferedReader( new FileReader("cantec_in.txt"));
		BufferedReader reader2 = new BufferedReader(new InputStreamReader(System.in));
		PrintStream writer = new PrintStream("cantec_out.txt");
		Vers vers;
		System.out.print("Cuvant: ");
		sir2 = reader2.readLine();
		while((sir = reader.readLine()) != null)
		{
			vers = new Vers(sir);
			writer.printf("%-80s", vers.Majuscule());
			if (vers.Cuvant_final(sir2) == 1)
				writer.printf("*\t");
			writer.printf(vers.Nr_cuvinte() + "\t" + vers.Nr_vocale() + "\n");
		}
		writer.close();
	}

}
