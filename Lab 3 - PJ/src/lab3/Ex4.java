package lab3;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

class Melodie
{
	private String nume_melodie;
	private String nume_artist;
	private int an;
	private int vizualizari;
	public Melodie(String nume_melodie, String nume_artist, int an, int vizualizari)
	{
		this.nume_melodie = nume_melodie;
		this.nume_artist = nume_artist;
		this.an = an;
		this.vizualizari = vizualizari;
	}
	public String getNume_melodie() {
		return nume_melodie;
	}
	public void setNume_melodie(String nume_melodie) {
		this.nume_melodie = nume_melodie;
	}
	public String getNume_artist() {
		return nume_artist;
	}
	public void setNume_artist(String nume_artist) {
		this.nume_artist = nume_artist;
	}
	public int getAn() {
		return an;
	}
	public void setAn(int an) {
		this.an = an;
	}
	public int getVizualizari() {
		return vizualizari;
	}
	public void setVizualizari(int vizualizari) {
		this.vizualizari = vizualizari;
	}
	@Override
	public String toString() {
		return String.format("%-25s %-25s %-15s %-15s", nume_melodie, nume_artist, an, vizualizari);
	}
}

public class Ex4 {

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new FileReader("in.txt"));
		BufferedReader reader2 = new BufferedReader(new InputStreamReader(System.in));
		Melodie[] melodie = new Melodie[10];
		Melodie aux;
		String str, nume_melodie, nume_artist;
		String[] str2;
		int an, vizualizari, count = 0;
		while((str = reader.readLine()) != null)
		{
			str2 = str.split("; ");
			nume_melodie = str2[0];
			nume_artist = str2[1];
			an = Integer.parseInt(str2[2]);
			vizualizari = Integer.parseInt(str2[3]);
			melodie[count] = new Melodie(nume_melodie, nume_artist, an, vizualizari);
			count++;
		}
		for(int i = 0; i < count; i++)
		{
			System.out.println(melodie[i].toString());
		}
		for(int i=0; i < count; i++)
		{
			for(int j=0; j < count - 1; j++)
			{
				if(melodie[j].getVizualizari() < melodie[j+1].getVizualizari())
				{
					aux = melodie[j];
					melodie[j] = melodie[j+1];
					melodie[j+1]=aux;
				}
			}
		}
		System.out.println();
		for(int i=0; i < count; i++)
		{
			System.out.println(melodie[i].toString());
		}
		System.out.print("\nNume artist: ");
		str = reader2.readLine();
		System.out.println();
		for(int i=0; i < count; i++)
		{
			if (melodie[i].getNume_artist().equals(str))
				System.out.println(melodie[i].toString());
		}
	}

}
