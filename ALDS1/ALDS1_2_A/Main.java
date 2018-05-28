import java.util.Scanner;

public class Main{
  static Scanner scan;
  static int counter = 0;

  static void bubbleSort(int[] array) {
    boolean flag = true;
    while(flag) {
      flag = false;
      for(int i = array.length - 1; i > 0; i--) {
        if(array[i] < array[i - 1]) {
          int temp = array[i];
          array[i] = array[i - 1];
          array[i - 1] = temp;
          counter++;
          flag = true;
        }
      }
    }
  }

  public static void main(String[] args) {
    scan = new Scanner(System.in);

    int n = scan.nextInt();
    int[] array  = new int[n];
    for(int i = 0; i < n; i++) {
      array[i] = scan.nextInt();
    }

    bubbleSort(array);

    for(int i = 0; i < n; i++) {
      System.out.printf("%d", array[i]);
      if(i != n - 1)
        System.out.print(" ");
    }
    System.out.println();
    System.out.printf("%d\n", counter);
  }
}
