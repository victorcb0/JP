package lab4;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

enum Stare {
	achizitionat,
	expus,
	vandut
}

enum Mod_de_scriere {
	tiparireColor,//color
	tiparireAlbNegru//albnegru
}

enum Mod_de_copiere {
	setFormatA4,//A4
	setFormatA3//A3
}

enum Sistem_de_operare {
	installWin,//windows
	installLinux//linux
}

class Echipament implements Serializable{
	private String denumire;
	private int nr_inv;
	private int pret;
	private String zona_mag;
	private Stare stare;
	public Echipament(String denumire, int nr_inv, int pret, String zona_mag, Stare stare) {
		this.denumire = denumire;
		this.nr_inv = nr_inv;
		this.pret = pret;
		this.zona_mag = zona_mag;
		this.stare = stare;
	}
	public String toString() {
		return String.format("%-45s %-7s %-7s %-5s %-15s", denumire, nr_inv, pret, zona_mag, stare);
	}
	public String getDenumire() {
		return denumire;
	}
	public void setDenumire(String denumire) {
		this.denumire = denumire;
	}
	public int getNr_inv() {
		return nr_inv;
	}
	public void setNr_inv(int nr_inv) {
		this.nr_inv = nr_inv;
	}
	public int getPret() {
		return pret;
	}
	public void setPret(int pret) {
		this.pret = pret;
	}
	public String getZona_mag() {
		return zona_mag;
	}
	public void setZona_mag(String zona_mag) {
		this.zona_mag = zona_mag;
	}
	public Stare getStare() {
		return stare;
	}
	public void setStare(Stare stare) {
		this.stare = stare;
	}
}

class Imprimanta extends Echipament {
	private int ppm;
	private String rezolutie;
	private int p_car;
	private Mod_de_scriere ms;
	public Imprimanta(String denumire, int nr_inv, int pret, String zona_mag, Stare stare, int ppm, String rezolutie, int p_car, Mod_de_scriere ms) {
		super(denumire, nr_inv, pret, zona_mag, stare);
		this.ppm = ppm;
		this.rezolutie = rezolutie;
		this.p_car = p_car;
		this.ms = ms;
	}
	public String toString() {
		return String.format("%-20s %s %-10s %-15s %-15s %-15s", "Imprimanta:", super.toString(), ppm, rezolutie, p_car, ms);
	}
	public int getPpm() {
		return ppm;
	}
	public void setPpm(int ppm) {
		this.ppm = ppm;
	}
	public String getRezolutie() {
		return rezolutie;
	}
	public void setRezolutie(String rezolutie) {
		this.rezolutie = rezolutie;
	}
	public int getP_car() {
		return p_car;
	}
	public void setP_car(int p_car) {
		this.p_car = p_car;
	}
	public Mod_de_scriere getMs() {
		return ms;
	}
	public void setMs(Mod_de_scriere ms) {
		this.ms = ms;
	}
}

class Copiatoare extends Echipament {
	private int ppm;
	private int p_ton;
	private Mod_de_copiere mc;
	public Copiatoare(String denumire, int nr_inv, int pret, String zona_mag, Stare stare, int ppm, int p_ton, Mod_de_copiere mc) {
		super(denumire, nr_inv, pret, zona_mag, stare);
		this.ppm = ppm;
		this.p_ton = p_ton;
		this.mc = mc;
	}
	public String toString() {
		return String.format("%-20s %s %-10s %-15s %-15s", "Copiatoare:", super.toString(), ppm, p_ton, mc);
	}
	public int getPpm() {
		return ppm;
	}
	public void setPpm(int ppm) {
		this.ppm = ppm;
	}
	public int getP_ton() {
		return p_ton;
	}
	public void setP_ton(int p_ton) {
		this.p_ton = p_ton;
	}
	public Mod_de_copiere getMc() {
		return mc;
	}
	public void setMc(Mod_de_copiere mc) {
		this.mc = mc;
	}
}

class Sistem_de_calcul extends Echipament {
	private String tip_mon;
	private float vit_proc;
	private int c_hdd;
	private Sistem_de_operare so;
	public Sistem_de_calcul(String denumire, int nr_inv, int pret, String zona_mag, Stare stare, String tip_mon, float vit_proc, int c_hdd, Sistem_de_operare so) {
		super(denumire, nr_inv, pret, zona_mag, stare);
		this.tip_mon = tip_mon;
		this.vit_proc = vit_proc;
		this.c_hdd = c_hdd;
		this.so = so;
	}
	public String toString() {
		return String.format("%-20s %s %-10s %-15s %-15s %-10s", "Sistem de calcul:", super.toString(), tip_mon, vit_proc, c_hdd, so);
	}
	public String getTip_mon() {
		return tip_mon;
	}
	public void setTip_mon(String tip_mon) {
		this.tip_mon = tip_mon;
	}
	public float getVit_proc() {
		return vit_proc;
	}
	public void setVit_proc(float vit_proc) {
		this.vit_proc = vit_proc;
	}
	public int getC_hdd() {
		return c_hdd;
	}
	public void setC_hdd(int c_hdd) {
		this.c_hdd = c_hdd;
	}
	public Sistem_de_operare getSo() {
		return so;
	}
	public void setSo(Sistem_de_operare so) {
		this.so = so;
	}
}

public class Ex1 {

	static void scrie(Object o, String fis) {
		try {
			FileOutputStream f = new FileOutputStream(fis);
			ObjectOutputStream oos = new ObjectOutputStream(f);
			oos.writeObject(o);
			oos.close();
			f.close();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}

	static Object citeste(String fis) {
		try {
			FileInputStream f = new FileInputStream(fis);
			ObjectInputStream ois = new ObjectInputStream(f);
			Object o=ois.readObject();
			ois.close();
			f.close();
			return o;
		}
		catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new FileReader("echipamente.txt"));
		BufferedReader reader1 = new BufferedReader(new InputStreamReader(System.in));
		String str, str_enum;
		String[] str2;
		Echipament[] ech = new Echipament[10];
		Echipament[] ech1;
		Imprimanta imp;
		Copiatoare cop;
		Sistem_de_calcul sc;
		int optiune, nr;
		
		int count = 0;
		while((str = reader.readLine()) != null)
		{
			str2 = str.split(";");
			switch(str2[5]) {
			case "imprimanta":
				if (str2[9].equalsIgnoreCase("color"))
					str_enum = "tiparireColor";
				else
					str_enum = "tiparireAlbNegru";
				ech[count] = new Imprimanta(str2[0], Integer.parseInt(str2[1]), Integer.parseInt(str2[2]), str2[3], Stare.valueOf(str2[4]), 
						Integer.parseInt(str2[6]), str2[7], Integer.parseInt(str2[8]), Mod_de_scriere.valueOf(str_enum));
				break;
			case "copiator":
				if (str2[8].equals("A3"))
					str_enum = "setFormatA3";
				else
					str_enum = "setFormatA4";
				ech[count] = new Copiatoare(str2[0], Integer.parseInt(str2[1]), Integer.parseInt(str2[2]), str2[3], Stare.valueOf(str2[4]), 
						Integer.parseInt(str2[6]), Integer.parseInt(str2[7]), Mod_de_copiere.valueOf(str_enum));
				break;
			case "sistem de calcul":
				if (str2[9].equals("windows"))
					str_enum = "installWin";
				else
					str_enum = "installLinux";
				ech[count] = new Sistem_de_calcul(str2[0], Integer.parseInt(str2[1]), Integer.parseInt(str2[2]), str2[3], Stare.valueOf(str2[4]), 
						str2[6], Float.parseFloat(str2[7]), Integer.parseInt(str2[8]), Sistem_de_operare.valueOf(str_enum));
				break;
			}
			count++;
		}
		do {
			System.out.println("1. Afisarea imprimantelor");
			System.out.println("2. Afisarea copiatoarelor");
			System.out.println("3. Afisarea sistemelor de calcul");
			System.out.println("4. Modificarea starii in care se afla un echipament");
			System.out.println("5. Setarea unui anumit mod de scriere");
			System.out.println("6. Setarea unui format de copiere pentru copiatoare");
			System.out.println("7. Instalarea unui anumit sistem de operare pe un sistem de calcul");
			System.out.println("8. Afisarea echipamentelor vandute");
			System.out.println("9. Serializare si deserializarea obiectelor");
			System.out.println("10. Exit");
			System.out.print("Optiune: ");
			optiune = Integer.parseInt(reader1.readLine());
			switch (optiune)
			{
			case 1:
				for(int i = 0; i < count; i++)
				{
					if (ech[i] instanceof Imprimanta)
						System.out.println(ech[i].toString());
				}
				break;
			case 2:
				for(int i = 0; i < count; i++)
				{
					if (ech[i] instanceof Copiatoare)
						System.out.println(ech[i].toString());
				}
				break;
			case 3:
				for(int i = 0; i < count; i++)
				{
					if (ech[i] instanceof Sistem_de_calcul)
						System.out.println(ech[i].toString());
				}
				break;
			case 4:
				for (int i = 0; i < count; i++)
					System.out.println(i + " " + ech[i].toString());
				System.out.print("Numarul echipamentului: ");
				nr = Integer.parseInt(reader1.readLine());
				System.out.print("Stare echipament: ");
				str = reader1.readLine();
				ech[nr].setStare(Stare.valueOf(str));
				break;
			case 5:
				for(int i = 0; i < count; i++)
				{
					if (ech[i] instanceof Imprimanta)
						System.out.println(i + " " + ech[i].toString());
				}
				System.out.print("Numarul imprimantei: ");
				nr = Integer.parseInt(reader1.readLine());
				System.out.print("Mod de scriere (tiparireColor / tiparireAlbNegru): ");
				str = reader1.readLine();
				imp = (Imprimanta) ech[nr];
				imp.setMs(Mod_de_scriere.valueOf(str));
				ech[nr] = imp;
				break;
			case 6:
				for(int i = 0; i < count; i++)
				{
					if (ech[i] instanceof Copiatoare)
						System.out.println(i + " " + ech[i].toString());
				}
				System.out.print("Numarul copiatorului: ");
				nr = Integer.parseInt(reader1.readLine());
				System.out.print("Format de copiere (setFormatA4 / setFormatA3): ");
				str = reader1.readLine();
				cop = (Copiatoare) ech[nr];
				cop.setMc(Mod_de_copiere.valueOf(str));
				ech[nr] = cop;
				break;
			case 7:
				for(int i = 0; i < count; i++)
				{
					if (ech[i] instanceof Sistem_de_calcul)
						System.out.println(i + " " + ech[i].toString());
				}
				System.out.print("Numarul sistemului de calcul: ");
				nr = Integer.parseInt(reader1.readLine());
				System.out.print("Sistem de operare (installWin / installLinux): ");
				str = reader1.readLine();
				sc = (Sistem_de_calcul) ech[nr];
				sc.setSo(Sistem_de_operare.valueOf(str));
				ech[nr] = sc;
				break;
			case 8:
				for(int i = 0; i < count; i++)
				{
					if (ech[i].getStare().equals(Stare.valueOf("vandut")))
						System.out.println(ech[i].toString());
				}
				break;
			case 9:
				scrie(ech, "echip.bin");
				ech1 = (Echipament[])citeste("echip.bin");
				for(Echipament ech2:ech1)
					if (ech2 != null)
						System.out.println(ech2);
				break;
			case 10:
				break;
			default:
				System.out.println("Optiune gresita!");
			}
		} while (optiune != 10);
	}

}
