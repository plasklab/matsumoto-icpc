import java.util.Scanner;
import java.util.Queue;
import java.util.ArrayDeque;

public class Main {
  int n;
  int[][] m;
  int[] visited;

  void solve(int v) {
    Queue<Integer> queue = new ArrayDeque<Integer>();
    queue.add(v);
    visited[v] = 0;
    
    while(queue.peek() != null) {
      v = queue.remove();
      for(int i = 0; i < m[v][0]; i++) {
        //System.out.println(m[v][i+1]);
        if(visited[m[v][i+1] - 1] == -1) {
          visited[m[v][i+1] - 1] = visited[v] + 1;
          queue.add(m[v][i+1] - 1);
        }
      }
    }
    
  }

  static Scanner scan;
  void run() {
    scan = new Scanner(System.in);
    n = scan.nextInt();
    m = new int[n][n];
    visited = new int[n];
    for(int i = 0; i < n; i++) {
      visited[i] = -1;
    }
    
    for(int i = 0; i < n; i++) {
      scan.nextInt();
      m[i][0] = scan.nextInt();
      for(int j = 0; j < m[i][0]; j++) {
        m[i][j+1] = scan.nextInt();
      }
    }

    solve(0);

    StringBuilder sb = new StringBuilder();
    for(int i = 0; i < n; i++) {
      sb.append((i+1) + " " + visited[i] + "\n");
    }
    System.out.print(sb);
  }

  public static void main(String[] args) {
    new Main().run();
  }
}