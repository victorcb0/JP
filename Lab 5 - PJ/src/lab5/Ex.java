package lab5;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;
import java.util.Set;
import java.util.Vector;

class Banca {
	private String denumire_banca;
	private List<Client> client;
	public Banca(String denumire_banca, List<Client> client)
	{
		this.denumire_banca = denumire_banca;
		this.client = client;
	}
	public String toString()
	{
		String str = "Banca: " + denumire_banca + "\nNume clienti:";
		for (Client i : client)
			str += "\n" + i.getNume();
		return str;
	}
	public String getDenumire_banca() {
		return denumire_banca;
	}
	public void setDenumire_banca(String denumire_banca) {
		this.denumire_banca = denumire_banca;
	}
	public List<Client> getClient() {
		return client;
	}
	public void setClient(List<Client> client) {
		this.client = client;
	}
}

class Client {
	private String nume;
	private String adresa;
	private Set<ContBancar> cont_bancar;
	public Client(String nume, String adresa, Set<ContBancar> cont_bancar)
	{
		this.nume = nume;
		this.adresa = adresa;
		this.cont_bancar = cont_bancar;
	}
	public String toString()
	{
		String str = "Nume: " + nume + "\nAdresa: " + adresa + "\nNumar conturi:";
		for(ContBancar i : cont_bancar)
			str += "\n" + i.getNumarCont();
		return str;
	}
	public String getNume() {
		return nume;
	}
	public void setNume(String nume) {
		this.nume = nume;
	}
	public String getAdresa() {
		return adresa;
	}
	public void setAdresa(String adresa) {
		this.adresa = adresa;
	}
	public Set<ContBancar> getCont_bancar() {
		return cont_bancar;
	}
	public void setCont_bancar(Set<ContBancar> cont_bancar) {
		this.cont_bancar = cont_bancar;
	}

}
class ContBancar implements Operatiuni{
	private String numarCont;
	private float suma;
	private String moneda;
	private Calendar data_deschidere;
	private Calendar data_ultimei_operatiuni;
	public ContBancar(String numarCont, float suma, String moneda, Calendar data_deschidere, Calendar data_ultimei_operatiuni) {
		this.numarCont = numarCont;
		this.suma = suma;
		this.moneda = moneda;
		this.data_deschidere = data_deschidere;
		this.data_ultimei_operatiuni = data_ultimei_operatiuni;
	}
	public String toString()
	{
		String data_d = String.format("%02d.%02d.%s", data_deschidere.get(Calendar.DATE), data_deschidere.get(Calendar.MONTH) + 1, data_deschidere.get(Calendar.YEAR));;
		String data_u = String.format("%02d.%02d.%s", data_ultimei_operatiuni.get(Calendar.DATE), data_ultimei_operatiuni.get(Calendar.MONTH) + 1, data_ultimei_operatiuni.get(Calendar.YEAR));
		String str = "Numar cont: " + numarCont + "\nSuma: " + suma + "\nMoneda: " + moneda + "\nData deschidere: " + data_d + "\nData ultimei operatiuni: " + data_u;
		return str;
	}
	@Override
	public float calculeaza_dobanda() {
		Calendar data_curenta = Calendar.getInstance();
		float dobanda;
		long zile = (data_curenta.getTimeInMillis() - data_ultimei_operatiuni.getTimeInMillis()) / (24 * 60 * 60 * 1000);
		if (moneda.equals("RONI"))
		{
			if (suma < 500)
				dobanda = (float) (zile * 0.3);
			else
				dobanda = (float) (zile * 0.8);
		}
		else
		{
			dobanda = (float) (zile * 0.1);
		}
		return dobanda;
	}
	@Override
	public float actualizare_suma() {
		Calendar data_curenta = Calendar.getInstance();
		suma += calculeaza_dobanda();
		data_ultimei_operatiuni = data_curenta;
		return suma;
	}
	@Override
	public void depunere(float suma) {
		Calendar data_curenta = Calendar.getInstance();
		this.suma += suma;
		data_ultimei_operatiuni = data_curenta;		
	}
	@Override
	public void extragere(float suma) {
		Calendar data_curenta = Calendar.getInstance();
		this.suma -= suma;
		data_ultimei_operatiuni = data_curenta;	
	}
	public String getNumarCont() {
		return numarCont;
	}
	public void setNumarCont(String numarCont) {
		this.numarCont = numarCont;
	}
	public float getSuma() {
		return suma;
	}
	public void setSuma(float suma) {
		this.suma = suma;
	}
	public String getMoneda() {
		return moneda;
	}
	public void setMoneda(String moneda) {
		this.moneda = moneda;
	}
	public Calendar getData_deschidere() {
		return data_deschidere;
	}
	public void setData_deschidere(Calendar data_deschidere) {
		this.data_deschidere = data_deschidere;
	}
	public Calendar getData_ultimei_operatiuni() {
		return data_ultimei_operatiuni;
	}
	public void setData_ultimei_operatiuni(Calendar data_ultimei_operatiuni) {
		this.data_ultimei_operatiuni = data_ultimei_operatiuni;
	}
}

interface Operatiuni {
	public float calculeaza_dobanda();
	public float actualizare_suma();
	public void depunere(float suma);
	public void extragere(float suma);
}

public class Ex {

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new FileReader("in.txt"));
		String str;
		Vector<Banca> banca = new Vector();
		while ((str = reader.readLine()) != null)
		{
			banca.add(null);
		}
		
		Calendar c = Calendar.getInstance();
		c.set(2012, 2, 6);
		String s;
		s = String.format("%02d.%02d.%s", c.get(Calendar.DATE), c.get(Calendar.MONTH) + 1, c.get(Calendar.YEAR));
		System.out.println(s);
	}

}