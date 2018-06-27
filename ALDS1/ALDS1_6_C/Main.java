import java.io.*;
import java.util.Scanner;
import java.util.Arrays;

public class Main {
  boolean isStable(String[] in, String[] out, int n) {
    char[] temp = new char[n];
    int tempi = 0;
    for(int i = 0; i < n - 1; i++) {
      temp[tempi] = out[i].charAt(0);
      tempi++;
      if(!out[i].substring(1).equals(out[i + 1].substring(1))) {
        //System.out.println(Arrays.toString(temp));
        //System.out.println(Arrays.toString(in));
        int j = 0;
        for(int k = 0; k < n; k++) {
          //System.out.println("out:" + out[i].substring(1) + " in" + in[k].substring(1));
          //System.out.println(out[i].substring(1).equals(in[k].substring(1)));
          if(out[i].substring(1).equals(in[k].substring(1))) {
            //System.out.println("temp:" + temp[j] + " in:" + in[k].charAt(0));
            if(temp[j] != in[k].charAt(0))
              return false;
            j++;
            if(j > tempi)
              break;
          }
        }
        temp = new char[n];
        tempi = 0;
      }
    }

    return true;
  }

  void swap(String[] a, int i, int j) {
    String temp = a[i];
    a[i] = a[j];
    a[j] = temp;
  }

  int partition(String[] a, int p, int r) {
    int x = Integer.parseInt(a[r].substring(1));
    int i = p - 1;
    for(int j = p; j < r; j++) {
      if(Integer.parseInt(a[j].substring(1)) <= x) {
        i++;
        swap(a, i, j);
      }
    }
    swap(a, i + 1, r);
    return i + 1;
  }

  void quickSort(String[] a, int p, int r) {
    if(p < r) {
      int q = partition(a, p, r);
      quickSort(a, p, q - 1);
      quickSort(a, q + 1, r);
    }
  }

  void run() {
      Scanner scan = new Scanner(System.in);
      int n = scan.nextInt();
      String[] a = new String[n];
      for(int i = 0; i < n; i++)
        a[i] = scan.next() + scan.nextInt();
      String[] input = a.clone();

      quickSort(a, 0, n - 1);

      if(isStable(input, a, n))
        System.out.print("S");
      else
        System.out.print("Not s");
      System.out.println("table");

      for(int i = 0; i < n; i++) {
        System.out.println(a[i].substring(0, 1) + " " + a[i].substring(1));
      }
  }

  public static void main(String[] args) {
    new Main().run();
  }
}
