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
      int left = 0;
      int right = n;
      while(left < right) {
        int mid = (left + right)/2;
        if(s[mid] == t) {
          counter++;
          break;
        }
        else if(s[mid] > t)
          right = mid;
        else
          left = mid + 1;
      }
    }
    System.out.println(counter);
  }

  public static void main(String[] args) {
    new Main().run();
  }
}
