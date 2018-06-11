import java.io.*;
import java.util.Scanner;

public class Main {
  static int counter = 0;
  void merge(int[] a, int left, int mid, int right) {
    int n1 = mid - left;
    int n2 = right - mid;
    int[] l = new int[n1 + 1];
    int[] r = new int[n2 + 1];
    for(int i = 0; i < n1; i++)
      l[i] = a[left + i];
    for(int i = 0; i < n2; i++)
      r[i] = a[mid + i];
    l[n1] = Integer.MAX_VALUE;
    r[n2] = Integer.MAX_VALUE;
    int i = 0;
    int j = 0;
    for(int k = left; k < right; k++) {
      if(l[i] <= r[j]) {
        a[k] = l[i];
        i++;
      } else {
        a[k] = r[j];
        j++;
      }
      counter++;
    }
  }

  void mergeSort(int[] a, int left, int right) {
    if(left + 1 < right) {
      int mid = (left + right) / 2;
      mergeSort(a, left, mid);
      mergeSort(a, mid, right);
      merge(a, left, mid, right);
    }
  }

  void run() {
    try {
      /*BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      String input;
      String[] splited;
      int n = Integer.parseInt(br.readLine());
      input = br.readLine();
      splited = input.split(" ");
      int[] s = new int[n];
      for(int i = 0; i < n; i++) {
        s[i] = Integer.parseInt(splited[i]);
      }*/

      Scanner scan = new Scanner(System.in);
      int n = scan.nextInt();
      int[] s = new int[n];
      for(int i = 0; i < n; i++) {
        s[i] = scan.nextInt();
      }

      mergeSort(s, 0, n);

      for(int i = 0; i < n; i++) {
        if(i != 0)
          System.out.print(" ");
        System.out.print(s[i]);
      }
      System.out.println("\n" + counter);

    } catch(Exception e) {
      e.printStackTrace();
    }

  }

  public static void main(String[] args) {
    new Main().run();
  }
}
