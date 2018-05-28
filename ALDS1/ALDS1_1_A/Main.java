import java.util.Scanner;

public class Main {

	static Scanner scan;

	static void insertionSort(int[] a, int n) {
		for(int i = 1; i < n; i++) {
			printProgression(a);
			int v = a[i];
			int j = i - 1;
			while(j >= 0 && a[j] > v) {
				a[j + 1] = a[j];
				j--;
			}
			a[j + 1] = v;
		}
	}

	static void printProgression(int[] progression) {
		for(int i = 0; i < progression.length; i++) {
			System.out.printf("%d", progression[i]);
			if(i < progression.length - 1)
				System.out.print(" ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		scan = new Scanner(System.in);
		int n = scan.nextInt();
		int[] a = new int[n];
		for(int i = 0; i < n; i++) {
			a[i] = scan.nextInt();
		}
		insertionSort(a, n);
		printProgression(a);
	}
}
