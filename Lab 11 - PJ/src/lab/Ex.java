package lab;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

class Angajat {
	int id;
	String numele;
	String postul;
	LocalDate data_angajarii;
	float salariul;
	public Angajat(int id, String numele, String postul, LocalDate data_angajarii, float salariul)
	{
		this.id = id;
		this.numele = numele;
		this.postul = postul;
		this.data_angajarii = data_angajarii;
		this.salariul = salariul;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNumele() {
		return numele;
	}
	public void setNumele(String numele) {
		this.numele = numele;
	}
	public String getPostul() {
		return postul;
	}
	public void setPostul(String postul) {
		this.postul = postul;
	}
	public LocalDate getData_angajarii() {
		return data_angajarii;
	}
	public void setData_angajarii(LocalDate data_angajarii) {
		this.data_angajarii = data_angajarii;
	}
	public float getSalariul() {
		return salariul;
	}
	public void setSalariul(float salariul) {
		this.salariul = salariul;
	}
	public String toString()
	{
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-YYYY");
		return id + ", " + numele + ", " + postul + ", " + formatter.format(data_angajarii) + ", " + salariul;
	}
}

public class Ex {

	static void afisare_salariu_3000(List<Angajat> pers, Predicate<Angajat> f) {
		for(Angajat p:pers)
		if(f.test(p))
			System.out.println(p.getSalariul());
	}
	
	/*static List<String> creare_lista(List<Angajat> pers, Predicate<Angajat> f) {
		List<String> nume = new ArrayList<String>();
		for(Angajat p:pers)
		if(f.test(p))
			nume.add(p.getNumele());
		return nume;
	}*/
	
	public static void main(String[] args) throws SQLException {
		String url = "jdbc:mysql://localhost:3306/test";
		Statement sql;
		ResultSet rs;
		Connection con = DriverManager.getConnection (url, "root", "root");
		sql = con.createStatement();
		rs = sql.executeQuery("select * from angajati");
		
		List<Angajat> angajat = new ArrayList<Angajat>();
		List<Angajat> angajat1;
		List<String> nume;
		
		while (rs.next())
			angajat.add(new Angajat(rs.getInt("id"), rs.getString("numele"), rs.getString("postul"), 
					rs.getDate("data_angajarii").toLocalDate(), rs.getFloat("salariu")));
		con.close();
		sql.close();
		rs.close();
		
		angajat
		.stream()
		.forEach(System.out::println);
		
		System.out.println();
		angajat
		.stream()
		.filter((ang) -> ang.getSalariul() > 2500)
		.forEach(System.out::println);
		
		System.out.println();
		LocalDate date = LocalDate.now();
		angajat1 = angajat
		.stream()
		.filter((ang) -> ang.getData_angajarii().getMonthValue() == 4  && date.getYear() == ang.getData_angajarii().getYear())
		.filter((ang) -> (ang.getPostul().equals("sef") || ang.getPostul().equals("director")))
		.collect (Collectors.toList());
		
		angajat1
		.stream()
		.forEach(System.out::println);
		
		/*Collections.sort(angajat, (Angajat a, Angajat b)->{
			if (a.getSalariul() > b.getSalariul()) 
				return -1;
			else
				if(a.getSalariul() < b.getSalariul()) 
					return 1;
				else return 0;
			});*/
		
		System.out.println();
		angajat
		.stream()
		.filter((ang) -> !(ang.getPostul().equals("sef") || ang.getPostul().equals("director")))
		.sorted((ang2, ang1) -> Float.compare(ang1.getSalariul(), ang2.getSalariul()))
		.forEach(System.out::println);
		
		/*System.out.println("");
		nume = creare_lista(angajat, (Angajat p)->p.getNumele().equals(p.getNumele().toUpperCase()));
		
		nume
		.stream()
		.forEach(System.out::println);*/
		
		System.out.println("");
		angajat
		.stream()
		.map(Angajat::getNumele)
		.map(String::toUpperCase)
		.forEach(System.out::println);
		
		System.out.println();
		afisare_salariu_3000(angajat, (Angajat p)->p.getSalariul() < 3000);
	}

}
