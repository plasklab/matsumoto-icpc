import java.util.Scanner;

public class Main {
  static Scanner scan;

  void run() {
    scan = new Scanner(System.in);
    int n = scan.nextInt();
    int[][] m = new int[n][n];
    int[][] a = new int[n][2];

    for(int i = 0; i < n; i++) {
      a[i][0] = scan.nextInt();
      a[i][1] = scan.nextInt();
    }

    for(int i = 0; i < n; i++)
      m[i][i] = 0;

    for(int l = 1; l < n; l++) {
      for(int i = 0; i < n - l; i++) {
        int j = i + l;
        m[i][j] = Integer.MAX_VALUE;
        for(int k = i; k < j; k++) {
          //System.out.println("l:" + l + " i:" + i + " j:" + j + " k:" + k);
          int q = m[i][k] + m[k+1][j] + a[i][0] * a[k][1] * a[j][1];
          if(q < m[i][j])
            m[i][j] = q;
        }
      }
    }
    System.out.println(m[0][n-1]);
  }


  public static void main(String[] args) {
    new Main().run();
    return;
  }
}
