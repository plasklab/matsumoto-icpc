import java.util.Scanner;

public class Main {

	static Scanner scan;

	static boolean isPrime(int n) {
		if(n == 2)
			return true;
		if(n < 2 || n % 2 == 0)
			return false;
		for(int i = 3; i <= Math.sqrt(n); i += 2)
			if(n % i == 0)
				return false;
		return true;
	}

	static int countPrime(int[] array) {
		int counter = 0;

		for(int i = 0; i < array.length; i++)
			if(isPrime(array[i]))
				counter++;
		return counter;
	}

	public static void main(String[] args) {
		scan = new Scanner(System.in);
		int n = scan.nextInt();
		int[] array = new int[n];
		for(int i = 0; i < n; i++) {
			array[i] = scan.nextInt();
		}

		System.out.printf("%d\n", countPrime(array));
	}
}
