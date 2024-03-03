package lab1;

import java.util.Random;

public class Ex5 {

	public static void main(String[] args) {
		Random ran = new Random();
		int a = ran.nextInt(21);
		int a0 = 0, a1 = 1, aux, val = 0;
		if (a == 0)
			val = 1;
		while (a1 <= 20 && (val == 0))
		{
			if (a == a1)
				val = 1;
			aux = a1;
			a1 += a0;
			a0 = aux;
		}
		if (val == 1)
			System.out.println("Numarul " + a + " apartine sirului lui Fibonacci");
		else
			System.out.println("Numarul " + a + " nu apartine sirului lui Fibonacci");
	}

}
