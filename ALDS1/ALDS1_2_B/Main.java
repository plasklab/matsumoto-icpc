import java.util.Scanner;

public class Main{
  static Scanner scan;
  static int counter = 0;

  static void swap(int[] array, int i, int j) {
    int temp = array[i];
    array[i] = array[j];
    array[j] = temp;
    counter++;
  }

  static void selectSort(int[] array) {
    for(int i = 0; i < array.length; i++) {
      int minj = i;
      boolean flag = false;
      for(int j = i; j < array.length; j++) {
        if(array[j] < array[minj]) {
          minj = j;
          flag = true;
        }
      }
      if(flag)
        swap(array, i, minj);
    }
  }

  public static void main(String[] args) {
    scan = new Scanner(System.in);

    int n = scan.nextInt();
    int[] array  = new int[n];
    for(int i = 0; i < n; i++) {
      array[i] = scan.nextInt();
    }

    selectSort(array);

    for(int i = 0; i < n; i++) {
      System.out.printf("%d", array[i]);
      if(i != n - 1)
        System.out.print(" ");
    }
    System.out.println();
    System.out.printf("%d\n", counter);
  }
}
