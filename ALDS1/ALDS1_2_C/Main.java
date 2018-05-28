import java.util.Scanner;
import java.util.Arrays;


public class Main{
  static Scanner scan;

  int pickValue(String str) {
    return str.charAt(1) - '0';
  }

  void swap(String[] array, int i, int j) {
    String temp = array[i];
    array[i] = array[j];
    array[j] = temp;
  }

  void printArray(String[] array, int n) {
    for(int i = 0; i < n; i++) {
      if(i != 0)
        System.out.print(" ");
      System.out.printf("%s", array[i]);
    }
    System.out.println();
  }

  void bubbleSort(String[] array) {
    boolean flag = true;
    while(flag) {
      flag = false;
      for(int i = array.length - 1; i > 0; i--) {
        if(pickValue(array[i]) < pickValue(array[i - 1])) {
          swap(array, i, i - 1);
          flag = true;
        }
      }
    }
  }

  void selectSort(String[] array) {
    for(int i = 0; i < array.length; i++) {
      int minj = i;
      boolean flag = false;
      for(int j = i; j < array.length; j++) {
        if(pickValue(array[j]) < pickValue(array[minj])) {
          minj = j;
          flag = true;
        }
      }
      if(flag)
        swap(array, i, minj);
    }
  }

  void run() {
    scan = new Scanner(System.in);

    int n = scan.nextInt();
    String[] array = new String[n];
    for(int i = 0; i < n; i++) {
      array[i] = scan.next();
    }
    String[] arrayForBubble = array.clone();
    String[] arrayForSelect = array.clone();

    bubbleSort(arrayForBubble);
    selectSort(arrayForSelect);

    printArray(arrayForBubble, n);
    System.out.println("Stable");
    printArray(arrayForSelect, n);
    if(!Arrays.deepEquals(arrayForBubble, arrayForSelect))
      System.out.print("Not s");
    else
      System.out.print("S");
    System.out.println("table");
  }

  public static void main(String[] args) {
    new Main().run();
  }
}
