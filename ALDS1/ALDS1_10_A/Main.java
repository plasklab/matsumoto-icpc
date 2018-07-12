import java.util.Scanner;

public class Main {
  static Scanner scan;
  static int[] table;

  int fib(int n) {
    if(n < 2) {
      return 1;
    } else if(table[n] != 0) {
      return table[n];
    } else {
      int ans = fib(n - 1) + fib(n - 2);
      table[n] = ans;
      return ans;
    }
  }

  void run() {
    scan = new Scanner(System.in);
    int n = scan.nextInt();
    table = new int[n + 1];
    System.out.println(fib(n));
  }

  public static void main(String[] args) {
    new Main().run();
    return;
  }
}
