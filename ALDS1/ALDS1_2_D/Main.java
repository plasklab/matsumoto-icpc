import java.util.Scanner;
import java.util.Arrays;


public class Main{
  static Scanner scan;
  static int counter = 0;

  void printArray(int[] array, int n) {
    for(int i = 0; i < n; i++)
      System.out.printf("%d\n", array[i]);
  }

  void insertionSort(int[] array, int n, int g) {
    for(int i = g; i < n; i++) {
      int v = array[i];
      int j = i - g;
      while(j >= 0 && array[j] > v) {
        array[j + g] = array[j];
        j = j - g;
        counter++;
      }
      array[j + g] = v;
    }
  }

  void shellSort(int[] array, int n) {
    counter = 0;
    int m = (int)Math.floor(Math.sqrt((n > 10000 ? (n > 100000 ? n/100 : n/10) : n)));
    System.out.printf("%d\n", m);

    int[] group = new int[m];
    int mi = m;
    for(int i = 0; i < m; i++) {
      group[i] = (int)Math.pow(mi, 2);
      mi--;
    }
    for(int i = 0; i < m; i++) {
      if(i != 0)
        System.out.print(" ");
      System.out.printf("%d", group[i]);
    }
    System.out.println();

    for(int i = 0; i < m; i++)
      insertionSort(array, n, group[i]);
  }

  void run() {
    scan = new Scanner(System.in);

    int n = scan.nextInt();
    int[] array = new int[n];
    for(int i = 0; i < n; i++) {
      array[i] = scan.nextInt();
    }

    shellSort(array, n);

    System.out.printf("%d\n", counter);
    printArray(array, n);
  }

  public static void main(String[] args) {
    new Main().run();
  }
}
