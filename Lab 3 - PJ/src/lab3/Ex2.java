package lab3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex2 {

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("Sir: ");
		StringBuilder sir = new StringBuilder(reader.readLine());
		System.out.print("Subsir: ");
		String subsir = reader.readLine();
		System.out.print("Pozitia inserarii: ");
		int pozitie = Integer.parseInt(reader.readLine());
		sir.insert(pozitie, subsir);
		System.out.println(sir);
		System.out.print("Pozitie stergere: ");
		pozitie = Integer.parseInt(reader.readLine());
		System.out.println("Numarul de caratere care vor fi sterse: ");
		int nr_caractere = Integer.parseInt(reader.readLine());
		sir.delete(pozitie, (pozitie + nr_caractere));
		System.out.println(sir);
	}

}
