import java.util.Scanner;
import javax.lang.model.util.ElementScanner6;
import java.util.Arrays;
import java.io.*;

public class Main {
  static int H;
  void buildMaxHeap(int[] a) {
    for(int i = (H+1)/2-1; i >= 0; i--)
      maxHeapify(a, i);
  }

  void maxHeapify(int[] a, int i) {
    int l = (i+1)*2-1;
    int r = (i+1)*2;
    int largest = i;
    if(l < H && a[l] > a[i])
      largest = l;
    if(r < H && a[r] > a[largest])
      largest = r;

    if(largest != i) {
      int temp = a[i];
      a[i] = a[largest];
      a[largest] = temp;
      maxHeapify(a, largest);
    }
  }

  void run() {
    try{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      H = Integer.parseInt(br.readLine());
      int[] a = new int[H];
      String input = br.readLine();
      int at = 0;
      for(int i = 0; i < H; i++) {
        StringBuilder sb = new StringBuilder(Character.toString(input.charAt(at)));
        at++;
        while(input.length() > at && input.charAt(at) != ' ' ) {
          sb.append(input.charAt(at));
          at++;
        }
        at++;
        a[i] = Integer.parseInt(sb.toString());
      }

      buildMaxHeap(a);

      StringBuilder sb = new StringBuilder();
      for(int i = 0; i < H; i++) {
        sb.append(" " + a[i]);
      }
      System.out.println(sb.toString());

    } catch(Exception e) {
      e.printStackTrace();
    }
  }

  public static void main(String[] args) {
    new Main().run();
    return;
  }
}
