import java.util.Scanner;

public class Main {

	static Scanner scan;

	static int solveGCD(int x, int y) {
		if(x < y) {
			int temp = x;
			x = y;
			y = temp;
		}

		while(y > 0) {
			int temp = x % y;
			x = y;
			y = temp;
		}
		return x;
	}

	public static void main(String[] args) {
		scan = new Scanner(System.in);
		int x = scan.nextInt();
		int y = scan.nextInt();

		System.out.printf("%d\n", solveGCD(y, x));
	}
}
