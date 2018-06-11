import java.util.Scanner;
import java.util.Arrays;

class Pool{
  int left;
  int right;
  int area;

  Pool(int left, int right, int area) {
    this.left = left;
    this.right = right;
    this.area = area;
  }
}

public class Main{
  static Scanner scan;

  void run(){
    scan = new Scanner(System.in);
    String input = scan.next();
    int i = 0;
    int[] stack = new int[input.length()];
    int top = 0;
    Pool[] pools = new Pool[input.length()/2];
    int counter = 0;

    while(i < input.length() && !"\\".equals(input.charAt(i) + ""))
      i++;

    while(i < input.length()) {
      if("\\".equals(input.charAt(i) + "")) {
        stack[top] = i;
        top++;
        i++;
      } else if("/".equals(input.charAt(i) + "") && top != 0) {
        boolean isNewPool = true;
        int j = 0;
        for(;j < counter; j++) {
          if(pools[j].left > stack[top - 1] && pools[j].right < i) {
            isNewPool = false;
            break;
          }
        }

        if(isNewPool) {
          //System.out.printf("%d, %d, %d\n", stack[top - 1], i, i - stack[top - 1]);
          pools[counter] = new Pool(stack[top - 1], i, i - stack[top - 1]);
          counter++;
        } else {
          pools[j].area += i - stack[top - 1];
          pools[j].left = stack[top - 1];
          pools[j].right = i;
          if(j != counter - 1) {
            int k = j + 1;
            int counter_ = counter;
            while(k < counter_) {
              //System.out.printf("counter%d, j%d, k%d\n", counter, j, k);
              pools[j].area += pools[k].area;
              pools[k] = null;
              counter--;
              k++;
            }
          }
        }
        top--;
        i++;
      } else {
        i++;
      }
    }

    int sum = 0;
    for(int j = 0; j < counter; j++) {
      sum += pools[j].area;
    }
    System.out.println(sum);
    System.out.printf("%d", counter);
    for(int j = 0; j < counter; j++) {
      System.out.printf(" %d", pools[j].area);
    }
    System.out.println();
  }

  public static void main(String[] args) {
    new Main().run();
  }
}
