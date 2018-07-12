import java.util.Scanner;
import javax.lang.model.util.ElementScanner6;
import java.util.Arrays;
import java.io.*;

public class Main {

  void run() {
    try{
      Scanner scan = new Scanner(System.in);
      int h = scan.nextInt();
      int[] a = new int[h];
      for(int i = 0; i < h; i++)
        a[i] = scan.nextInt();

      StringBuilder sb = new StringBuilder();
      for(int i = 0; i < h; i++) {
        sb.append("node " + (i+1) + ": key = " + a[i] + ", ");
        if(i != 0)
          sb.append("parent key = " + a[((i+1)/2-1 > 0 ? (i+1)/2-1 : 0)] + ", ");
        if((i+1)*2-1 < h)
          sb.append("left key = " + a[(i+1)*2-1] + ", ");
        if((i+1)*2 < h)
          sb.append("right key = " + a[(i+1)*2] + ", ");
        sb.append("\n");
      }

      System.out.print(sb.toString());

    } catch(Exception e) {
      e.printStackTrace();
    }
  }

  public static void main(String[] args) {
    new Main().run();
    return;
  }
}
