import java.util.Scanner;
import java.util.Arrays;
import java.io.*;

public class Main {
  void countingSort(int[] a, int[] b, int n, int k) {
    int[] c = new int[k + 1];

    //System.out.println(a.length + " " + b.length + " " + n + " " + k);
    for(int i = 1; i < n + 1; i++)
      c[a[i - 1]]++;

      /*System.out.print("c ");
      for(int i = 0; i < c.length; i++) {
        if(i != 0)
          System.out.print(" ");
        System.out.print(c[i]);
      }
      System.out.println();*/

    for(int i = 1; i < k + 1; i++)
      c[i] += c[i - 1];

    /*System.out.print("c ");
    for(int i = 0; i < c.length; i++) {
      if(i != 0)
        System.out.print(" ");
      System.out.print(c[i]);
    }
    System.out.println();*/

    for(int i = n; i > 0; i--) {
      /*System.out.println(a[i]);
      System.out.println(c[a[i]]);
      System.out.println(b[c[a[i]] - 1]);*/
      b[c[a[i - 1]] - 1] = a[i - 1];
      c[a[i - 1]]--;
    }
  }

  void run() {
    try{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      //Scanner scan = new Scanner(System.in);
      int n = Integer.parseInt(br.readLine());
      int[] a = new int[n];
      int k = Integer.MIN_VALUE;
      //Integer c = 0;

      //String[] input = (br.read.split(" ");
      //String[] splited = input;

      //long s = System.currentTimeMillis();

      String input = br.readLine();
      int j = 0;
      for(int i = 0; i < n; i++) {
        StringBuilder sb = new StringBuilder(Character.toString(input.charAt(j)));
        j++;
        while(input.length() > j && input.charAt(j) != ' ' ) {

          sb.append(input.charAt(j));
          //System.out.println("input:" + input.charAt(j) + ": sb:" + sb.toString() + ":");
          j++;
        }
        j++;
        a[i] = Integer.parseInt(sb.toString());
        if(k < a[i])
          k = a[i];
      }

      /*for(int i = 0; i < n; i++) {
        a[i] = Integer.parseInt(scan.next());
        if(k < a[i])
          k = a[i];
      }*/

      //long time1 = System.currentTimeMillis() - s;
      //s = System.currentTimeMillis();

      /*for(int i = 0; i < n; i++) {
        if(k < a[i])
          k = a[i];
      }*/
      //long time2 = System.currentTimeMillis() - s;
      /*for(int i = 0; i < n; i++) {
        c = br.read();
        StringBuilder str = new StringBuilder(new String(new byte[]{c.byteValue()}, "US-ASCII"));
        c = br.read();
        while(c.intValue() != 32 && c.intValue() != 10) {
          str.append(new String(new byte[]{c.byteValue()}, "US-ASCII"));
          c = br.read();
        }
        a[i] = Integer.parseInt(str.toString());
        if(k < a[i])
          k = a[i];
      }*/


      int[] b = new int[n];

      //long s = System.currentTimeMillis();

      countingSort(a, b, n, k);

      //long time1 = System.currentTimeMillis() - s;

      StringBuilder sb = new StringBuilder();
      for(int i = 0; i < n; i++) {
        if(i != 0)
          sb.append(" ");
        sb.append(b[i]);
      }
      System.out.println(sb.toString());

      //System.out.println(time1);
    } catch(Exception e) {
      e.printStackTrace();
    }
  }

  public static void main(String[] args) {
    //long s = System.currentTimeMillis();
    new Main().run();
    //s = System.currentTimeMillis() - s;
    //System.out.println(s);
  }
}
