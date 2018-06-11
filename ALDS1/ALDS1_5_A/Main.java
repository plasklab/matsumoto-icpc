import java.io.*;

public class Main {
  int n;
  String[] a;
  boolean solve(int i, int m) {
    if(m == 0)
      return true;
    if(i >= n)
      return false;
    return (solve(i + 1, m) || solve(i + 1, m - Integer.parseInt(a[i])));
  }
  void run() {
    try {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      String input;
      String[] splited;
      n = Integer.parseInt(br.readLine());
      input = br.readLine();
      a = input.split(" ");
      int q = Integer.parseInt(br.readLine());
      input = br.readLine();
      String[] m = input.split(" ");

      for(int i = 0; i < q; i++) {
        if(solve(0, Integer.parseInt(m[i])))
          System.out.println("yes");
        else
            System.out.println("no");
      }

    } catch(Exception e) {
      e.printStackTrace();
    }

  }

  public static void main(String[] args) {
    new Main().run();
  }
}
