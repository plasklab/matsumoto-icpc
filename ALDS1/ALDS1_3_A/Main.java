import java.util.Scanner;


public class Main{
  static Scanner scan;
  static final int MAX = 200;
  
  void run() {
    scan = new Scanner(System.in);
    int[] stack = new int[MAX];
    int i = 0;
    int ans = 0;


    while(scan.hasNext()) {
      String op = scan.next();
      if("+".equals(op) || "-".equals(op) || "*".equals(op)) {
        int rop = stack[--i];
        int lop = stack[--i];
        if("+".equals(op))
          ans = lop + rop;
        else if("-".equals(op))
          ans = lop - rop;
        else if("*".equals(op))
          ans = lop * rop;
        stack[i] = ans;
        i++;
      } else {
        stack[i] = Integer.parseInt(op);
        i++;
      }
    }
    System.out.printf("%d\n", stack[--i]);
  }

  public static void main(String[] args) {
    new Main().run();
  }
}
