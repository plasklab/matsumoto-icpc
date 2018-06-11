import java.util.Scanner;

public class Main{
  static Scanner scan;

  void run(){
    scan = new Scanner(System.in);
    int n = scan.nextInt();
    int[] s = new int[n];
    for(int i = 0; i < n; i++)
      s[i] = scan.nextInt();
    int q = scan.nextInt();
    int counter = 0;
    int t = 0;
    for(int i = 0; i < q; i++) {
      t = scan.nextInt();
      for(int j = 0; j < n; j++) {
        if(t == s[j]) {
          counter++;
          break;
        }
      }
    }
    System.out.println(counter);
  }

  public static void main(String[] args) {
    new Main().run();
  }
}
