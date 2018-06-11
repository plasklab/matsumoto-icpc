import java.util.Scanner;


public class Main{
  static Scanner scan;
  static final int N_MAX = 100000;

  void run() {
    scan = new Scanner(System.in);
    int n = scan.nextInt();
    int q = scan.nextInt();
    String[] nameQueue = new String[N_MAX];
    int[] timeQueue = new int[N_MAX];
    int head = 0;
    int tail = n;
    for(int i = 0; i < n; i++) {
      nameQueue[i] = scan.next();
      timeQueue[i] = scan.nextInt();
    }

    int clock = 0;

    while(head != tail) {
      String name = nameQueue[head];
      int time = timeQueue[head];
      if(head + 1 > n)
        head = 0;
      else
        head++;

      if(time >= q) {
        clock += q;
        time -= q;
      } else {
        clock += time;
        time = 0;
      }

      if(time > 0) {
        nameQueue[tail] = name;
        timeQueue[tail] = time;
        if(tail + 1 > n)
          tail = 0;
        else
          tail++;
      } else {
        System.out.printf("%s %d\n", name, clock);
      }
    }


  }

  public static void main(String[] args) {
    new Main().run();
  }
}
