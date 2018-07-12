import java.io.*;

public class Main {
  static int[][] m;
  static char[] str1;
  static char[] str2;
  int solve(int x, int y) {
    int match = (str1[x-1] == str2[y-1] ? 1 : 0);

    return Math.max(Math.max(m[x-1][y-1] + match, m[x-1][y]), m[x][y-1]);
  }

  void run() {
    try{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int n = Integer.parseInt(br.readLine());
      for(;n > 0; n--) {
        str1 = br.readLine().toCharArray();
        str2 = br.readLine().toCharArray();
        m = new int[str1.length + 1][str2.length + 1];
        for(int i = 1; i <= str1.length; i++) {
          for(int j = 1; j <= str2.length; j++) {
            m[i][j] = solve(i, j);
          }
        }
        System.out.println(m[str1.length][str2.length]);
      }

    } catch(Exception e) {
      e.printStackTrace();
    }
  }


  public static void main(String[] args) {
    new Main().run();
    return;
  }
}
