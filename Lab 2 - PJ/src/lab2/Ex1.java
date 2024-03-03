package lab2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Parabola
{
	private double a, b, c;
	//private double varf_x, varf_y;
	public Parabola(double a, double b, double c)
	{
		this.a = a;
		this.b = b;
		this.c = c;
	}
	public Parabola(Parabola x)
	{
		this(x.a, x.b, x.c);
	}
	public void afisare()
	{
		System.out.println("f(x)= " + a + "*x^2 + " + b + "*x + " + c);
	}
	public void calcul_varf(double []varf)
	{
		varf[0] = (-b)/(2*a);
		varf[1] = (-b*b+4*a*c)/(4*a);
	}
	public static void mijloc_segment(Parabola p0, Parabola p1)
	{
		double []varf0 = new double[2];
		double []varf1 = new double[2];
		p0.calcul_varf(varf0);
		p1.calcul_varf(varf1);
		double x = (varf0[0] + varf1[0])/2;
		double y = (varf0[1] + varf1[1])/2;
		System.out.println("Mijloc segment:");
		System.out.println("x = " + x);
		System.out.println("y = " + y);
	}
}

public class Ex1 {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("a0 = ");
		double a = Double.parseDouble(reader.readLine());
		System.out.print("b0 = ");
		double b = Double.parseDouble(reader.readLine());
		System.out.print("c0 = ");
		double c = Double.parseDouble(reader.readLine());
		Parabola p0 = new Parabola(a, b, c);
		p0.afisare();
		System.out.print("a1 = ");
		a = Double.parseDouble(reader.readLine());
		System.out.print("b1 = ");
		b = Double.parseDouble(reader.readLine());
		System.out.print("c1 = ");
		c = Double.parseDouble(reader.readLine());
		Parabola p1 = new Parabola(a, b, c);
		p1.afisare();
		Parabola.mijloc_segment(p0, p1);
	}

}
