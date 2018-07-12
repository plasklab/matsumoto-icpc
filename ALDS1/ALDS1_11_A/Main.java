import java.util.Scanner;

public class Main {
  static Scanner scan;
  void run() {
    scan = new Scanner(System.in);
    int n = scan.nextInt();
    int[][] m = new int[n][n];
    
    for(int i = 0; i < n; i++) {
      scan.nextInt();
      int d = scan.nextInt();
      //System.out.println("d" +d);
      int count = 0;
      int v = 0;
      for(int j = 0; j < n; j++) {
        if(d > count && j == v) {
          v = scan.nextInt();
          //System.out.println("v:" + v);
          count++;
        }
        
        m[i][j] = (j == v-1 ? 1 : 0);
      }
      //System.out.println("out");
    }
    StringBuilder sb = new StringBuilder();
    for(int i = 0; i < n; i++) {
      for(int j = 0; j < n; j++) {
        sb.append(m[i][j] + (j != n-1 ? " " : ""));
      }
      sb.append("\n");
    }
    System.out.print(sb);
  }

  public static void main(String[] args) {
    new Main().run();
  }
}