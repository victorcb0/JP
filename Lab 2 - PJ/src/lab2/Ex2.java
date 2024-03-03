package lab2;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;

class Produs {
	
	private String denumire;
	private float pret;
	private float cantitate;
	public Produs(String denumire, float pret, float cantitate)
	{
		this.denumire = denumire;
		this.pret = pret;
		this.cantitate = cantitate;
	}
	public String getDenumire()
	{
		return denumire;
	}
	public float getPret()
	{
		return pret;
	}
	public float getCantitate()
	{
		return cantitate;
	}
	public String toString()
	{
		return String.format("%-10s %-10s %-10s", denumire, pret, cantitate);
	}
	
}

public class Ex2 {

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader( new FileReader("in.txt"));
		BufferedReader reader1 = new BufferedReader( new InputStreamReader(System.in));
		String str, denumire;
		String[] str1;
		int count = 0;
		float pret, cantitate, minim = Integer.MAX_VALUE, maxim = Integer.MIN_VALUE;
		Produs[] p = new Produs[3];
		Produs minimP = null, maximP = null;
		while((str = reader.readLine()) != null)
		{
			str1 = str.split(";", 3);
			denumire = str1[0];
			pret = Float.parseFloat(str1[1]);
			cantitate = Float.parseFloat(str1[2]);
			p[count] = new Produs(denumire, pret, cantitate);
			count++;
		}
		for(int i=0; i<count; i++)
		{
			if (minim > p[i].getPret())
			{
				minim = p[i].getPret();
				minimP = p[i];
			}
		}
		for(int i=0; i<count; i++)
		{
			if (maxim < p[i].getPret())
			{
				maxim = p[i].getPret();
				maximP = p[i];
			}
		}
		for(int i=0; i<count; i++)
		{
			System.out.println(p[i].toString());
		}
		System.out.println();
		System.out.print("Cantitate: ");
		cantitate = Float.parseFloat(reader1.readLine());
		for(int i=0; i<count; i++)
		{
			if (cantitate > p[i].getCantitate())
			System.out.println(p[i].toString());
		}
		PrintStream writer = new PrintStream("out.txt");
		writer.printf("Produsul cu pret minim: \n");
		writer.printf("%-10s %-10s %-10s\n\n", minimP.getDenumire(), minimP.getPret(), minimP.getCantitate());
		writer.printf("Produsul cu pret maxim: \n");
		writer.printf("%-10s %-10s %-10s", maximP.getDenumire(), maximP.getPret(), maximP.getCantitate());
		writer.close();
	}
	
}
