package lab1;

import java.util.Random;

public class Ex4 {

	public static void main(String[] args) {
		Random ran = new Random();
		int a = ran.nextInt(31), b = ran.nextInt(31), min, cmmdc = 0;
		if (a < b)
			min = a;
		else
			min = b;
		System.out.println("a = " + a);
		System.out.println("b = " + b);
		for(int i = 1; i <= min; i++)
		{
			if ((a % i == 0) && (b % i == 0))
				cmmdc = i;
		}
		System.out.println("Cmmdc: " + cmmdc);
	}

}
