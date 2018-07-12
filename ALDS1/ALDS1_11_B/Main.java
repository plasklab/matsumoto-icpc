import java.util.Scanner;

public class Main {
  int n;
  int[][] m;
  int[][] visited;
  int time = 1;

  void solve(int v) {
    if(visited[v][0] == 0) {
      visited[v][0] = time;
      time++;
    } else {
      return;
    }
    
    for(int i = 0; i < m[v][0]; i++) {
      //System.out.println("v:" + v + " i:" + i);
      solve(m[v][i+1] - 1);
    }

    visited[v][1] = time;
    time++;
    
  }

  static Scanner scan;
  void run() {
    scan = new Scanner(System.in);
    n = scan.nextInt();
    m = new int[n][n];
    visited = new int[n][2];
    
    for(int i = 0; i < n; i++) {
      scan.nextInt();
      m[i][0] = scan.nextInt();
      for(int j = 0; j < m[i][0]; j++) {
        m[i][j+1] = scan.nextInt();
      }
    }
    for(int i = 0; i < n; i++)
      solve(i);


    StringBuilder sb = new StringBuilder();
    for(int i = 0; i < n; i++) {
      sb.append((i+1) + " " + visited[i][0] + " " + visited[i][1] + "\n");
    }
    System.out.print(sb);
  }

  public static void main(String[] args) {
    new Main().run();
  }
}